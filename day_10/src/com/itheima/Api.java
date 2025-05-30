package com.itheima;

public class Api {
    public static void main(String[] args){
        String str = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的";
        String tar = "Java";
        int count = cal(str,tar);
        System.out.println(count);
    }
    public static int cal(String str,String tar){
        int count = 0;
        while(true){
         int index = str.indexOf(tar);
         if(index!=-1){
             count++;
             str = str.substring(index+tar.length());
         }
         else{
             return count;
         }

        }
    }
}
