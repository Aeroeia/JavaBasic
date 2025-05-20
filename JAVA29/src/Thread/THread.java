package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//继承Runnanle接口
public class THread implements  Runnable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        eight();
    }
    public static void one(){
        T1 thread1 = new T1();
        T1 thread2 = new T1();

        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();

    }
    public static void two(){
        THread th = new THread();
        Thread t1 = new Thread(th);
        Thread t2 = new Thread(th);
        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
    public static void three() throws ExecutionException, InterruptedException {
        T2 t = new T2();
        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread t = Thread.currentThread();
                System.out.println(t.getName());
                Thread.sleep(3000);
                return 10;
            }
        });
        Thread thread = new Thread(ft);
        thread.start();
        //获取结果
        Integer i = ft.get();
        System.out.println(i);

    }
    //sleep方法
    public static void four() throws InterruptedException {
        System.out.println("a");
        Thread.sleep(2000);
        System.out.println("b");
    }
    //setpriority
    public static void five(){
        T1 t = new T1();
        Thread t1 = new Thread(t,"a");
        Thread t2 = new Thread(t,"b");
        t1.setPriority(10);
        t2.setPriority(7);
        t1.start();
        t2.start();
    }
    //setDaemon 守护线程陆续结束并不需要全部运行
    public static void six(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                }
            }
        },"a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=100;i++){
                    System.out.println(Thread.currentThread().getName()+"  "+i);
                }
            }
        },"b");
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
    //礼让线程 yield
    //尽可能让输出更加均匀一点
    public static void seven(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"  "+(i+1));
                    Thread.yield();
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"  "+(i+1));
                    Thread.yield();
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
    //插入线程 join
    public static void eight() throws InterruptedException {
        Thread t1 = new Thread(new T1(),"t1");
        t1.start();
        t1.join();
        for(int i = 0;i<10;i++){
            System.out.println("main   "+(i+1));
        }
    }
    //实现Runnable接口
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for(int i = 0;i<10;i++){
            System.out.println(t.getName()+"   Runnable");
        }
    }

}
//继承Thread
class T1 extends Thread{
    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+(i+1));
        }
    }
}

//继承Callable接口 表示返回值类型为Integer
class T2 implements Callable<Integer> {

    //返回多线程运行的结果
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0;i<10;i++){
            sum+=i;
        }
        return sum;
    }
}