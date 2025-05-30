package com.itheima;

import java.util.StringJoiner;

public class ConnectStr {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        String str = connect(arr);
        System.out.println(str);
    }
    public static String connect(int[] arr ){
          if(arr == null){
              return null;
          }

        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < arr.length; i++) {
         sj.add(arr[i]+"");
        }
        return sj.toString();
    }
}
