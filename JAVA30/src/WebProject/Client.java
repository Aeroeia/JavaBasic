package WebProject;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("A",10086);
        System.out.println("请输入用户名");
        Scanner sc = new Scanner(System.in);
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        os.write(sc.next());
        os.write("&");
        System.out.println("请输入密码");
        os.write(sc.next());
        os.newLine();
        os.flush();
        BufferedReader isr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = isr.readLine();
        if(s.equals("登录成功")) {
            while (true) {
                System.out.println("请输入");
                String str = sc.next();
                os.write(str);
                os.newLine();
                os.flush();
                System.out.println(isr.readLine());
                if (str.equals("886")) {
                    break;
                }
            }
        }
    }
}
