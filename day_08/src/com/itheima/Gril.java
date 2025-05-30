package com.itheima;

public class Gril
{
    private int age;
    // set赋值
    public void setAge(int a)
    {
        if(a>0)
            age = a;
        else
            System.out.println("非法数据");
    }
    //get取值
    public int getAge(){
        return age;
    }
}