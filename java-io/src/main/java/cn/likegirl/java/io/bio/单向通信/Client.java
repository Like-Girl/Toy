package cn.likegirl.java.io.bio.单向通信;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final static String HOST = "127.0.0.1";

    private final static Integer PORT = 8400;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            socket = new Socket(HOST,PORT);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);

            pw.println("hello");

            String response = br.readLine();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket!=null){
                    socket.close();
                }
                if(br!=null){
                    br.close();
                }
                if(pw!=null){
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
