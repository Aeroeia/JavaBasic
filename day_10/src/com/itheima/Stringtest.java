package com.itheima;

import java.util.Scanner;

public class Stringtest {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        String str = set.next();
        int up = 0;
        int down = 0;
        int num = 0;
        for(int i = 0;i<str.length();i++)
        {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                up++;
            }
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                down++;
            }
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                num++;
            }
        }
        System.out.printf("num = %d up = %d down = %d",num,up,down);
    }
}
