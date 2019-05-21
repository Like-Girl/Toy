package cn.likegirl.网络编程.nio.多客户端聊天室;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class ClientReadThread implements Runnable {

    /**
     * 缓冲区
     */
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    /**
     * 字符集
     */
    private final Charset charset = Charset.forName("UTF-8");

    /**
     * 服务端断开，客户端的读事件不会一直发生（与服务端不一样）
     */
    private Boolean isUsable = Boolean.TRUE;

    public ClientReadThread(Selector selector) {
        this.selector = selector;

    }

    /**
     * 多路服务器
     */
    private Selector selector;

    @Override
    public void run() {
        SelectionKey key;
        SocketChannel sc;
        try {
            while (isUsable) {
                this.selector.select();  //调用此方法一直阻塞，直到有channel可用
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    key = keys.next();
                    if (key.isReadable()) {
                        sc = (SocketChannel) key.channel();
                        this.buffer.clear();
                        StringBuilder body = new StringBuilder();
                        try {
                            while (sc.read(buffer) > 0) {
                                // 复位
                                this.buffer.flip();
                                body.append(charset.decode(buffer));
                            }
                        } catch (IOException en) {
                            System.out.println(en.getMessage() + ",客户端'" + key.attachment().toString() + "'读线程退出！！");
                            this.stopMainThread();
                        }
                        System.out.println(body.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopMainThread(){
        this.isUsable = false;
    }
}
