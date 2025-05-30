package com.ByteDance;

public class Cat extends Animal{
    @Override
    public void eat(String sth){
        System.out.println("猫在吃"+sth);
    }
    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }


}
