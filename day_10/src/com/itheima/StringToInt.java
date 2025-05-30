package com.itheima;

public class StringToInt {
    public static void main(String[] args){
        String num1 = "12";
        String num2 = "11";
        String result = tonum(num1,num2);
        System.out.println(result);
    }
    public static String tonum(String num1,String num2){
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        long n1 = 0;
        long n2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            n1 = n1*10+(long)(arr1[i]-'0');
        }
        for (int i = 0; i < arr2.length; i++) {
            n2 = n2*10+(long)(arr2[i]-'0');
        }
        long n = n1*n2;
        long flag = n;
        int count = 0;
        while(flag>0){
            flag/=10;
            count++;
        }
        char[] arr = new char[count];
        for(int i = count-1;i>=0;i--){
            arr[i] =(char)(n%10+'0');
            n/=10;
        }
        return new String(arr);
    }
}
