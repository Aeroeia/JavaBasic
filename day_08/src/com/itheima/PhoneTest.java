package com.itheima;

public class PhoneTest {
    public static void main(String[] args)
    {
        //创建Phone的对象
        Phone p = new Phone();
        //给Phone赋值
        p.brand = "华为";
        p.price = 3199.9;
        //获取Phone对象中的值
        System.out.println(p.brand);
        System.out.println(p.price);
        //调用Phone中的方法
        p.call();
        p.playgame();
    }
}
