package cn.likegirl.java.jvm.io.bio.广播聊天室;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerHandler implements Runnable {

    private Socket socket;

    private List<Socket> sockets;

    public ServerHandler(Socket socket, List<Socket> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String request = br.readLine();
                System.out.println("服务器收到：" + request);
                for(Socket s : sockets){
                    pw = new PrintWriter(s.getOutputStream());
                    pw.println(request);
                    pw.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null){
                    br.close();
                }
                if(pw != null){
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
