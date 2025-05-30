package com.itheima;

import java.util.Scanner;

public class Loginpra {
    public static void main(String[] args){
        //生成用户
        Login admin = new Login();
        admin.setUsername("Jiang");
        admin.setPassword("687A");
        Scanner set = new Scanner(System.in);
        //登录
        for (int i = 0; i < 3; i++) {
            Login ad = new Login();
            System.out.println("请输入用户名");
            ad.setUsername(set.next());
            System.out.println("请输入密码");
            ad.setPassword(set.next());
           if(check(admin,ad)){
               System.out.println("登陆成功");
               break;
           }
           else if(i==2){
               System.out.println("输入错误次数上限");
           }
           else{
               System.out.println("用户名或者密码错误，请重新输入");

           }



        }
    }
    public static boolean check(Login admin,Login ad){
        boolean checkusername = admin.getUsername().equals(ad.getUsername());
        boolean checkpassword = admin.getPassword().equals(ad.getPassword());
        if(checkusername && checkpassword){
            return true;
        }
        else {
            return false;
        }
    }

}
