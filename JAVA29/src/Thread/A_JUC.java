package Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class    A_JUC {
    public static void main(String[] args) {
        four();
    }

    private static void one() {
        Win w1 = new Win();
        Win w2 = new Win();
        Win w3 = new Win();

        w1.start();
        w2.start();
        w3.start();
    }
    private static void two(){
        Winn w = new Winn();
        Thread win1 = new Thread(w,"w1");
        Thread win2 = new Thread(w,"w2");
        Thread win3 = new Thread(w,"w3");
        win1.start();
        win2.start();;
        win3.start();
    }
    private static void three(){
        Win w1 = new Win("win1");
        Win w2 = new Win("win2");
        Win w3 = new Win("win3");
        w1.start();
        w2.start();
        w3.start();
    }
    private static void four(){
        ArrayList<Integer> ary = new ArrayList<>();
        Collections.addAll(ary,10,5,20,50,100,200,500,800,2,80,300,700);
        My_Call mc1 = new My_Call(ary);
        My_Call mc2 = new My_Call(ary);
        FutureTask<Integer> ft1 = new FutureTask<>(mc1);
        FutureTask<Integer> ft2 = new FutureTask<>(mc2);
        Thread t1 = new Thread(ft1,"抽奖箱1");
        Thread t2 = new Thread(ft2,"抽奖箱2");
        t1.start();
        t2.start();
        try {
            System.out.println(t1.getName()+"最大值为"+ft1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(t2.getName()+"最大值为"+ft2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


}
class Win extends Thread{
    static int ticket = 0;
    static Lock lock = new ReentrantLock();
    public Win(){

    }
    public Win(String name){
        super(name);
    }
    @Override
    public void run() {
//        while(true){
            //锁
//            synchronized (Win.class){
//                if(ticket<100){
//
//                    ticket++;
//                    System.out.println("第"+ticket+"张票正在售出!!!");
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                else{
//                    break;
//                }
//            }
            while(true){
                lock.lock();
                try {
                    if(ticket<100){
                        ticket++;
                        System.out.println(Thread.currentThread().getName()+"  "+ticket);
                            Thread.sleep(10);
                    }
                    else{
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    lock.unlock();
                }
            }
        }

}
class Winn implements Runnable{
    int ticket = 0;
    @Override
    public void run() {
        while(true){
            if(work()){
                break;
            }
        }
    }
    private synchronized boolean work(){
        if(ticket<100){
            ticket++;
            System.out.println(Thread.currentThread().getName()+"  "+ticket);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
        else{
            return true;
        }
    }
}
class My_Call implements Callable<Integer>{
     ArrayList<Integer> ary;
    public My_Call(ArrayList<Integer> ary){
        this.ary = ary;
    }
    ArrayList<Integer> boxlist = new ArrayList<>();
    @Override
    public Integer call() throws Exception {
        int max = 0;
        Random r = new Random();
        while(true){
            synchronized (My_Call.class){
                if(ary.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"  "+boxlist);
                    break;
                }
                else{
                    int index = r.nextInt(ary.size());
                    int num = ary.get(index);
                    if(num==800){
                        if(Thread.currentThread().getName().equals("抽奖箱1")){
                            ary.remove(index);
                            max = num;
                            boxlist.add(num);
                        }
                    }
                    else{
                        ary.remove(index);
                        boxlist.add(num);
                        if(num>max){
                            max = num;
                        }
                    }
                }
            }
            Thread.sleep(10);
        }
        if(boxlist.isEmpty()){
            return null;
        }
        return max;
    }
}



