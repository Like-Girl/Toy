package cn.likegirl.网络编程.nio.多客户端聊天室;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ClientWriteThread implements Runnable {

    private final String separator = "|";

    /**
     * 字符集
     */
    private final Charset charset = Charset.forName("UTF-8");

    /**
     * 服务端断开，客户端的读事件不会一直发生（与服务端不一样）
     */
    private Boolean isUsable = Boolean.TRUE;

    private String name = "";

    /**
     * 多路服务器
     */
    private Selector selector;

    private SocketChannel socketChannel;

    public ClientWriteThread(Selector selector,SocketChannel socketChannel){
        this.selector = selector;
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (isUsable) {
            input = scanner.nextLine();
            if ("".equals(input)) {
                System.out.println("不允许输入空串！");
                continue;
            } else if ("".equals(name) && input.split("[|]").length == 1) {
                name = input;
                //给通道添加名称
                this.selector.keys().iterator().next().attach(name);
            } else if (!"".equals(name) && input.split("[|]").length == 2) {
                input = input + separator + name;
            } else {
                System.out.println("输入不合法，请重新输入：");
                continue;
            }
            try {
                this.socketChannel.write(charset.encode(input));
            } catch (Exception e) {
                System.out.println(e.getMessage() + "客户端主线程退出连接！！");
                this.stopMainThread();
            }
        }
    }

    private void stopMainThread() {
        isUsable = false;
    }
}
