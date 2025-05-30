package com.ByteDance;

public class PingPangPly extends Person implements SpecialSkills{
    @Override
    public void work(){
        System.out.println("学打乒乓球");
    }
    @Override
    public void skills(){
        System.out.println("说英语");
    }
    public PingPangPly(){

    }

    public PingPangPly(String name, int age) {
        super(name, age);
    }
}
