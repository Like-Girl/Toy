package cn.likegirl.网络编程.nio.多客户端聊天室;

import cn.likegirl.utils.ThreadPoolManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Client {
    private static final Integer PORT = 8400;

    /**
     * 客户端通道
     */
    private SocketChannel socketChannel;

    /**
     * 多路复用器
     */
    private Selector selector;


    public void startClient() {
        try {
            //NIO client初始化固定流程：4步
            // 1.打开多路复用器
            this.selector = Selector.open();
            // 2.打开客户端通道
            this.socketChannel = SocketChannel.open(new InetSocketAddress(PORT));
            // 3.配置通道非阻塞
            this.socketChannel.configureBlocking(false);
            // 4.将channel的读事件注册到选择器
            this.socketChannel.register(selector, SelectionKey.OP_READ);

            // 读操作
            ThreadPoolManager.newInstance().addExecuteTask(new ClientReadThread(this.selector));
            // 写操作
            ThreadPoolManager.newInstance().addExecuteTask(new ClientWriteThread(this.selector, this.socketChannel));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new Client().startClient();

    }
}
