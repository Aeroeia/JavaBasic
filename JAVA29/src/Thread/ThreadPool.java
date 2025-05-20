package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
            one();
    }
    public static void one(){
        ExecutorService exe = Executors.newCachedThreadPool();
        exe.submit(new My_Runnable());
        exe.submit(new My_Runnable());
        exe.shutdown();
    }
}
class My_Runnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
}

