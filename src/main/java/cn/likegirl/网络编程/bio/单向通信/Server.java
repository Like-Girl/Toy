package cn.likegirl.网络编程.bio.单向通信;

import cn.likegirl.utils.ThreadPoolManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static Integer PORT = 8400;

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(PORT);
            while (true){
                Socket socket = ss.accept();
                ThreadPoolManager.newInstance().addExecuteTask(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ss!=null){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
