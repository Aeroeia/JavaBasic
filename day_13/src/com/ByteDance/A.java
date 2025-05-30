package com.ByteDance;

public class A {
    public static void main(String[] args){
           Person s = new Student();
           s.work();
           if(s instanceof Student){
               Student ss = (Student) s;
               ss.test();
           }
           else{
               System.out.println("不是这个类型");
           }

    }
}
