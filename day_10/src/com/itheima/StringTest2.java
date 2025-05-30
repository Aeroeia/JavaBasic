package com.itheima;

public class StringTest2 {
    public static void main(String[] args){
        int[] arr ={1,2,3};
        String str = change(arr);
        System.out.println();
        System.out.println("["+str+"]");
    }
    public static String change(int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                str = str+arr[i]+',';
            }
            else{
                str = str+arr[i];
            }
        }
        return str;
    }
}
