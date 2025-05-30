package com.itheima;

public class Changechart {
    public static void main(String[] args){
        String a = "abcde";
        String b = "eabcd";
        boolean flag = judge(a,b);
        a = spin(a);
        System.out.println(a);
        System.out.println(flag);
    }
    public static String spin(String a){
        StringBuilder sb = new StringBuilder();
        for (int i = a.length()-1; i >=0; i--) {
            sb.append(a.charAt(i));
        }
        a = sb.toString();
        return a;
    }
    public static boolean judge(String a,String b){
        char[] arr = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            arr[i] = a.charAt(i);
        }
        if(a.length()!=b.length()){
            return false;
        }
        int i ;
        for ( i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < arr.length; i1++) {
                sb.append(arr[i1]);
            }
            String aa = sb.toString();
            if(aa.equals(b)){
                return true;
            }
            char tmp = arr[0];
            for(int j = 0;j<arr.length-1;j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = tmp;
        }
        return false;
    }
    public static String rotate1(String str){
        char first = str.charAt(0);
        String end = str.substring(1);
        return first + end;
    }
    public static String rotate2(String str){
        char[] arr = str.toCharArray();
        char tmp = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = tmp;
        String result = new String(arr);
        return result;
    }
}
