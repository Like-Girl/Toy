package cn.likegiirl.lintcode.网络编程.nio.多客户端聊天室;


import cn.likegirl.utils.ThreadPoolManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 网络多客户端聊天室
 * <p>
 * 功能1： 客户端通过Java NIO连接到服务端，支持多客户端的连接
 * 功能2：客户端初次连接时，服务端提示输入昵称，如果昵称已经有人使用，提示重新输入，如果昵称唯一，则登录成功，之后发送消息都需要按照规定格式带着昵称发送消息
 * 功能3：客户端登录后，发送已经设置好的欢迎信息和在线人数给客户端，并且通知其他客户端该客户端上线
 * 功能4：服务器收到已登录客户端输入内容，转发至其他登录客户端。
 * 功能5：如果客户端断线，要能在服务端做相应的处理
 */
public class Server implements Runnable {
    /**
     * 端口
     */
    private static final Integer PORT = 8400;
    /**
     * 消息分隔符
     */
    private final String separator = "[|]";
    /**
     * 字符集
     */
    private final Charset charset = Charset.forName("UTF-8");
    /**
     * 缓存
     */
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    /**
     * 将用户对应的channel对应起来
     */
    private Map<String, SocketChannel> onlineUsers = new HashMap<>();

    /**
     * 多路复用器
     */
    private Selector selector;

    public Server() {
        //NIO server初始化固定流程：5步
        try {
            // 1.开启多路复用器
            this.selector = Selector.open();
            // 2.打开服务端通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            // 3.设置通道阻塞模式
            ssc.configureBlocking(false);
            // 4.绑定端口地址
            ssc.bind(new InetSocketAddress(PORT));
            // 5.把服务器通道注册呆多路复用器上，并且监听阻塞时件
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        //NIO server处理数据固定流程:5步
        // 轮询
        while (true) {
            try {
                // 1.多路复用器开始监听,用select()方法阻塞，一直到有可用连接加入
                this.selector.select();
                // 2.返回对路复用器所有注册通道
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                // 3.遍历所有的key
                while (keys.hasNext()) {

                    // 4.处理
                    SelectionKey key = keys.next();
                    if (key.isValid()) {
                        //SelectionKey.OP_CONNECT
                        //SelectionKey.OP_ACCEPT
                        //SelectionKey.OP_READ
                        //SelectionKey.OP_WRITE

                        // 阻塞事件
                        if (key.isAcceptable()) {
                            this.accept(key);
                        }
                        // 可读事件
                        if (key.isReadable()) {
                            this.read(key);
                        }
                    }

                    // 5.从容器中移除已经被选中的key
                    keys.remove();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {
        try {
            // 1.由于目前是server端，那么一定是server端启动 并且处于阻塞状态 所以获取阻塞状态为的key 一定是:ServerSocketChannel
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            // 2.通过调用accept()方法,返回一个具体的客户端连接句柄
            SocketChannel sc = ssc.accept();
            // 3.设置客户端通道为非阻塞
            sc.configureBlocking(false);
            // 4.设置当前获取的客户端连接句柄为可读状态位
            sc.register(this.selector, SelectionKey.OP_READ);

            System.out.println("+++++客户端：" + sc.getRemoteAddress() + "，建立连接+++++");
            sc.write(this.charset.encode("请输入自定义用户名："));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        // 1.对缓冲区进行清空
        this.buffer.clear();
        // 2.获取之前注册的socketChannel通道对象
        SocketChannel sc = (SocketChannel) key.channel();
        StringBuilder body = new StringBuilder();
        try {
            while (sc.read(this.buffer) > 0) {
                this.buffer.flip();
                body.append(this.charset.decode(buffer));
            }
            if (body.length() > 0) {
                this.processMsg(body.toString(), sc, key);
            }

        } catch (IOException e) {
            //如果client.read(buffer)抛出异常，说明此客户端主动断开连接，需做下面处理
            try {
                //关闭channel
                key.channel().close();
                //将channel对应的key置为不可用
                key.cancel();
                //将问题连接从map中删除
                onlineUsers.values().remove(sc);
                System.out.println("-----用户'" + key.attachment().toString() + "'退出连接，当前用户列表：" + onlineUsers.keySet().toString() + "-----");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * 处理客户端传来的消息
     *
     * @param msg 格式：user_to|body|user_from
     */
    private void processMsg(String msg, SocketChannel socketChannel, SelectionKey key) {
        try {
            String[] ms = msg.split(separator);
            if (ms.length == 1) {
                // 输入的是自定义用户名
                String user = ms[0];
                if (onlineUsers.containsKey(user)) {
                    socketChannel.write(charset.encode("当前用户已存在，请重新输入用户名："));
                } else {
                    onlineUsers.put(user, socketChannel);
                    //给通道定义一个表示符
                    key.attach(user);
                    String welCome = "\t欢迎'" + user + "'上线，当前在线人数" + this.getOnLineNum() + "人。用户列表：" + onlineUsers.keySet().toString();
                    //给所用用户推送上线信息，包括自己
                    this.broadCast(welCome);
                }
            } else if (ms.length == 3) {
                String userTo = ms[0];
                String msgBody = ms[1];
                String userFrom = ms[2];

                SocketChannel channel = onlineUsers.get(userTo);
                if (channel == null) {
                    socketChannel.write(charset.encode("用户'" + userTo + "'不存在，当前用户列表：" + onlineUsers.keySet().toString()));
                } else {
                    channel.write(charset.encode("来自'" + userFrom + "'的消息：" + msgBody));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * map中的有效数量已被很好的控制，可以从map中获取，也可以用下面的方法取
     */
    private int getOnLineNum() {
        int count = 0;
        Channel channel;
        for (SelectionKey k : selector.keys()) {
            channel = k.channel();
            //排除ServerSocketChannel
            if (channel instanceof SocketChannel) {
                count++;
            }
        }
        return count;
    }

    /**
     * 广播消息
     */
    private void broadCast(String msg) throws IOException {
        Channel channel;
        for (SelectionKey k : selector.keys()) {
            channel = k.channel();
            if (channel instanceof SocketChannel) {
                SocketChannel client = (SocketChannel) channel;
                client.write(charset.encode(msg));
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolManager.newInstance().addExecuteTask(new Server());
    }

}
