package com.itheima;

import java.util.Random;

public class VerifyCode {
    public static void main(String[] args){
        char[] chart = new char[52];
        for (int i = 0; i < chart.length; i++) {
            if(i<26){
                chart[i] = (char)('a'+i);
            }
            else{
                chart[i] =(char)('A'+i-26);
            }
        }
       String str = generatecode(chart);
        System.out.println(str);
    }
    public static String generatecode(char[] chart){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(chart[r.nextInt(chart.length)]);
        }
        sb.append(r.nextInt(10));
        String s = sb.toString();
        s = stirup(s);
        return s;
    }
    public static String stirup(String s){
        char[] arr = s.toCharArray();
        Random r = new Random();
        int index = r.nextInt(arr.length);
        char tmp = arr[arr.length-1];
        arr[arr.length-1] = arr[index];
        arr[index] = tmp;
        return new String(arr);
    }
}
