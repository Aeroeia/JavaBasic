package com.itheima;

import java.util.Scanner;

public class Transfer {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        int n;
        String num;
       String[] chart = {"","Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ"};
        while(true){
            System.out.println("输入一个小于等于9的数字");
            int tmp = set.nextInt();
            if(tmp>9){
                System.out.println("请重新输入");
            }
            else{
                n = tmp;
                break;
            }
        }
        num = chart[n];
        System.out.println(num);
    }

}
