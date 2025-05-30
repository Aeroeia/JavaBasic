package com.itheima;

import java.util.Scanner;

public class ReturnLength {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        String s = set.nextLine();
        int length = getLength(s);
        System.out.println(length);
    }
    public static int getLength(String s){
        int count = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
