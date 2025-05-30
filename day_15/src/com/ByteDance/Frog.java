package com.ByteDance;

public class Frog extends Animal implements Swim{
    @Override
    public void swim(){
        
    }
    @Override
    public void action(){
        System.out.println();
    }
    public Frog(){
        super();
    }
    public Frog(String name,int age){
        super(name,age);
    }
}
