package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class StirUp {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        String str = set.next();
        str = stirup(str);
        System.out.println(str);
    }
    public static String stirup(String str){
        char[] arr = str.toCharArray();
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            char tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        return new String(arr);
    }
}
