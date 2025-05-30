package com.itheima;

public class debug {
    public static void main(String[] args){
      int[] a = new int[3];
      int[] b = {1,2,3,4,5};
      a = b;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
