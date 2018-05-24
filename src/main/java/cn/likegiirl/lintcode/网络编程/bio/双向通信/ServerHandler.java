package cn.likegiirl.lintcode.网络编程.bio.双向通信;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author LikeGirl
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedInputStream bis = null;
        PrintWriter out = null;
        try {
            bis = new BufferedInputStream(this.socket.getInputStream());
            out = new PrintWriter(this.socket.getOutputStream());
            while (true){
                byte[] b = new byte[1024];
                int len;
                if( (len = bis.read(b)) > 0){
                    System.out.print(new String(b,0,len));
                }
                out.print("hello client");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
