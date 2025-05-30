package com.itheima;

import java.util.Scanner;

public class practice {
    public static void main(String[] args)
    {
       /*int sum = 0;
        for(int i = 1;i<=100;i++)
        {
            if(i%2 == 0)
            {
                sum = sum+i;
            }
        }
        System.out.println(sum);
        Scanner set = new Scanner(System.in);
        int a = set.nextInt();
        int b = set.nextInt();
        int n = 0;
        for(int i= a;i<=b;i++)
        {
            if(i%3==0 && i%5==0)
            {
                n++;
            }
        }
        System.out.println(n);

        // 珠穆朗玛峰
        int n = 0;
        long height = 8844430;
        double init = 0.1;
        while(init< height)
        {
            init = init*2;
            n++;
        }
        System.out.println(n);*/
        //回文
        Scanner set = new Scanner(System.in);
        int x = set.nextInt();
        int n = 0;
        int flag = x;
        while(flag>0)
        {
            n = n*10+(flag%10);
            flag/=10;
        }
        if(n==x)
        {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
