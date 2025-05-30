package com.itheima;

import java.util.Scanner;

public class IfSymmetry {
    public static void main(String[] args) {
        Scanner set = new Scanner(System.in);
        String s = set.next();
        System.out.println(ifSymmetry(s));
    }
    public static boolean ifSymmetry(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String ss = sb.toString();
        if(s.equals(ss)){
            return true;
        }
        return false;
    }
}
