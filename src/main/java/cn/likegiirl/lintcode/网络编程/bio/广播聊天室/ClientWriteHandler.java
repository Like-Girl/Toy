package cn.likegiirl.lintcode.网络编程.bio.广播聊天室;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriteHandler implements Runnable {

    private Socket socket;

    public ClientWriteHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入内容:");
                pw.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
