package com.ByteDance;

public class Dog extends Animal{
    @Override
    public void eat(String sth){
        System.out.println("狗在吃"+sth);
    }
    public void lookHome(){
        System.out.println("狗在看家");
    }
}
