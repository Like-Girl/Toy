package cn.likegirl.网络编程.bio.双向通信;

import cn.likegirl.utils.ThreadPoolManager;

import java.io.*;
import java.net.Socket;

/**
 * @author LikeGirl
 */
public class Client {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8400;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            //开启两个线程，一个负责读，一个负责写
            ThreadPoolManager.newInstance().addExecuteTask(new ClientWriteHandlerThread(socket));
            ThreadPoolManager.newInstance().addExecuteTask(new ClientReadHandlerThread(socket));
//            new Thread(new ClientReadHandlerThread(socket)).start();
//            new Thread(new ClientWriteHandlerThread(socket)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *处理读操作的线程
 */
class ClientReadHandlerThread implements Runnable{
    private Socket client;

    public ClientReadHandlerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            while(true){
                //读取服务器端数据
                dis = new DataInputStream(client.getInputStream());
                String receive = dis.readUTF();
                System.out.println("服务器端返回过来的是: " + receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(dis != null){
                    dis.close();
                }
                if(client != null){
                    client = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 处理写操作的线程
 */
class ClientWriteHandlerThread implements Runnable{
    private Socket client;

    public ClientWriteHandlerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        BufferedReader br = null;
        try {
            while(true){
                //取得输出流
                dos = new DataOutputStream(client.getOutputStream());
                System.out.print("请输入: \t");
                //键盘录入
                br = new BufferedReader(new InputStreamReader(System.in));
                String send = br.readLine();
                //发送数据
                dos.writeUTF(send);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally{
            try{
                if(dos != null){
                    dos.close();
                }
                if(br != null){
                    br.close();
                }
                if(client != null){
                    client = null;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
