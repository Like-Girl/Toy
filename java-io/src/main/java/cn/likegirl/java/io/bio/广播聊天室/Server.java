package cn.likegirl.java.io.bio.广播聊天室;

import cn.likegirl.utils.ThreadPoolManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final static Integer PORT = 8400;

    public static void main(String[] args) {


        ServerSocket ss = null;

        List<Socket> sockets = new ArrayList<>();

        try {
            ss = new ServerSocket(PORT);
            while (true){
                Socket socket = ss.accept();
                sockets.add(socket);
                ThreadPoolManager.newInstance().addExecuteTask(new ServerHandler(socket,sockets));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(ss != null){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
