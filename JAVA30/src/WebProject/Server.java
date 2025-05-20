package WebProject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        ArrayList<Socket> ary = new ArrayList<>();
        while(true){
            Socket socket = ss.accept();
            new Thread(new MyRunnable(socket,ary)).start();
        }
    }
}
class MyRunnable implements Runnable{
    Socket socket;
    ArrayList<Socket> sockets;
    MyRunnable(Socket socket,ArrayList<Socket> ary){
        this.socket = socket;
        this.sockets = ary;
    }
    @Override
    public void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = bf.readLine();
            BufferedReader fbr = new BufferedReader(new FileReader("JAVA30\\src\\WebProject\\userInfo.txt"));
            String s;
            ArrayList<String> ary = new ArrayList<>();
            while((s = fbr.readLine())!=null){
                ary.add(s);
            }
            boolean flag = false;
            for(int i = 0;i<ary.size();i++){
                if(ary.get(i).equals(str)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                sockets.add(socket);
                BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                osw.write("登录成功");
                osw.newLine();
                osw.flush();
                while(true){
                     String ss = bf.readLine();
                      for(var temp:sockets){
                          osw = new BufferedWriter(new OutputStreamWriter(temp.getOutputStream()));
                          osw.write(ss);
                          osw.newLine();
                          osw.flush();
                      }
                  if(ss.equals("886")){
                      break;
                  }
                }
            }
            else{
                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                osw.write("用户名或密码错误或不存在");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
