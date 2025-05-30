package com.itheima;

import java.util.Scanner;

/*public class practice
{
    public static void main(String[] args) {
        数值拆分:
        Scanner set = new Scanner(System.in);
        int a = set.nextInt();
        while(a>0)
        {
            System.out.println(a%10);
            a/=10;*/
        /*Scanner set = new Scanner(System.in);
        int a = set.nextInt();
        int b = set.nextInt();
        System.out.println(a==b);
         输出6和6的倍数 真假
        Scanner set = new Scanner(System.in);
        int a = set.nextInt();
        int b = set.nextInt();
        if(a == 6 || b==6 || (a+b)%6==0)
            System.out.println(true);
        else
        { System.out.println(false);}


        }
        计算
        Scanner set = new Scanner(System.in);
        int dad = set.nextInt();
        int mom = set.nextInt();
        double son = (dad + mom) * 1.08 / 2;
        double daught = (dad * 0.923 + mom )/2;
        System.out.println(son);
        System.out.println(daught);
    }
}*/
/*
public class practice
{
    public static void main(String[] args)
    {
        int fish = 24;
        int peanunt = 8;
        int rice = 3;
        double sum1 = 0;
        double sum2 = 0;
        if((fish+peanunt+rice)>=30)
        {
            sum1 = (fish+peanunt+rice)*0.8;
        }
        else {
            sum1 = fish+peanunt+rice;
        }
        sum2 = fish-16+peanunt+rice;
        double result = sum1<sum2?sum1:sum2;
        System.out.println(result);
    }
}
*/
public class practice
{
    public static void main(String[] args)
    {
        Scanner set = new Scanner(System.in);
        int day = set.nextInt();
        switch(day)
        {
            case 1,2,3,4,5->System.out.println("工作日");
            case 6,7->System.out.println("休息日");
            default->System.out.println("输入错误");
        }

    }
}
