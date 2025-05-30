package com.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPra {
    public static void main(String[] args){
        ArrayList<User> userlist = new ArrayList<>();
        Scanner set = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
           User user = new User();
            System.out.println("print id");
            user.setId(set.nextLong());
            System.out.println("print name");
            user.setUsername(set.next());
            System.out.println("print password");
            user.setPassword(set.next());
            userlist.add(user);
        }
        System.out.println(check(userlist));
    }
    public static boolean check(ArrayList<User> userlist){
        System.out.println("输入要查询的id");
        Scanner set = new Scanner(System.in);
        long id = set.nextLong();
        for (int i = 0; i < userlist.size(); i++) {
            if(id == userlist.get(i).getId()){
                return true;
            }
        }
        return false;
    }
}
