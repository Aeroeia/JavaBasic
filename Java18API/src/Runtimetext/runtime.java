package Runtimetext;

import java.io.IOException;

public class runtime {
    public static void main(String[] args) throws IOException {
          //Runtime为运行环境  对象唯一
        Runtime rt1 = Runtime.getRuntime();
        Runtime rt2 = Runtime.getRuntime();
        System.out.println(rt1==rt2);




        //获得CPU线程
        System.out.println(Runtime.getRuntime().availableProcessors());

        //虚拟机总内存大小
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

        //已经获取内存大小
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);

        //剩余内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);

        //运行cmd命令
        System.out.println(Runtime.getRuntime().exec("notepad"));

        Runtime.getRuntime().exec("shutdown -a"); //-s -t 3600
        //停止虚拟机
        Runtime.getRuntime().exit(0);
    }
}
