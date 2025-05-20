package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class java {
    public static void main(String[] args) {
        ArrayList<Integer> ary = new ArrayList<>();
       ary.add(3);
       ary.add(2);
       ary.add(1);
       ary.add(5);
       ary.add(6);
       ary.add(4);
        System.out.println(ary);
        heapify(ary);
        System.out.println(ary);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        

    }
    public static void heapify(ArrayList<Integer> ary){
        int size = ary.size();
        for(int i = size/2-1;i>=0;i--){
            down(ary,i);
        }
    }
    public static void down(ArrayList<Integer> ary, int index){
        int parent = index;
        int child = parent*2+1;
        while(child<ary.size()){
            if(child+1<ary.size()&&ary.get(child+1)>ary.get(child)){
                child++;
            }
            if(ary.get(child)<ary.get(parent)){
                break;
            }
            int temp = ary.get(child);
            ary.set(child, ary.get(parent));
            ary.set(parent, temp);
            parent = child;
            child = parent*2+1;
        }
    }

}
