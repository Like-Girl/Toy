package cn.likegiirl.lintcode.网络编程.bio.广播聊天室;

import cn.likegirl.utils.ThreadPoolManager;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private final static String HOST = "127.0.0.1";

    private final static Integer PORT = 8400;

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket(HOST,PORT);

            ThreadPoolManager.newInstance().addExecuteTask(new ClientWriteHandler(socket));
            ThreadPoolManager.newInstance().addExecuteTask(new ClientReadHandler(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
