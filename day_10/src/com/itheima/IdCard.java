package com.itheima;

import java.util.Scanner;

public class IdCard {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        String id = set.next();
        System.out.println(ifLegal(id));
    }
    public static boolean ifLegal(String id ){
        if(id.length()!=18){
            return false;
        }
        for (int i = 0; i < id.length(); i++) {
            if(id.charAt(i)>'9' || id.charAt(i)<'0'){
                return false;
            }
        }
        if(!(id.charAt(id.length()-1)>='0'&&id.charAt(id.length()-1)<='9'||id.charAt(id.length()-1)=='X'))
            return false;
        return true;
    }
}
