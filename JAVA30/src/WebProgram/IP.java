package WebProgram;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class IP {
    public static void main(String[] args) throws IOException {
        exe2();
    }

    private static void exe1() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    two();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    three();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }

    //ip地址
    private static void one() throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("A");
        System.out.println(ip);
    }
    //udp发送数据
    public static void two() throws IOException {
        DatagramSocket ds =new DatagramSocket();
        String str = "Hello World";
        byte[] data = str.getBytes();
        InetAddress ip = InetAddress.getByName("A");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(data,data.length,ip,port);
        ds.send(dp);
        ds.close();
    }
    //接收数据
    public static void three() throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        System.out.println(new String(data,0, dp.getLength()));
        System.out.println(dp.getAddress());
        ds.close();
    }

    //TCP
    public static void exe2(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tcp1();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tcp2();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
    public static void tcp1() throws IOException {
        Socket sk = new Socket("A",10086);
        OutputStream os = sk.getOutputStream();
        String str = "你好";
        os.write(str.getBytes());
        os.close();
        sk.close();
    }
    public static void tcp2() throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket sk = ss.accept();
        InputStreamReader isr = new InputStreamReader(sk.getInputStream());
        char[] data = new char[1024];
        int len;
        while((len = isr.read(data))!= -1){
            System.out.println(new String(data,0,len));
        }
        isr.close();
        sk.close();
        ss.close();
    }

}
