package System;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserScreen {
    public static void main(String[] args){
        System.out.println("欢迎来到学生管理系统");
        Scanner set = new Scanner(System.in);
        ArrayList<User> userlist = new ArrayList<>();
        while(true){
            System.out.println("请选择：1.登录 2.注册 3.忘记密码 4.退出");
            int input = set.nextInt();
            switch (input){
                case 1-> login(userlist);
                case 2-> signup(userlist);
                case 3-> forgetpsw(userlist);
                case 4-> {
                    System.out.println("退出");
                    System.exit(0);
                }
                case 5-> show(userlist);
                default -> System.out.println("输入错误，请重新输入");
            }
        }
    }
    //遍历集合
    public static void show(ArrayList<User> userlist){
        for (int i = 0; i < userlist.size(); i++) {
            User user = userlist.get(i);
            System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getIdcard()+" "+user.getPhone());
        }

    }
    //注册
    public static void signup(ArrayList<User> userlist){
        System.out.println("请输入用户名");
        System.out.println("用户名长度必须在3~15位之间 ");
        System.out.println("只能是字母加数字的组合，但是不能是纯数字");
        Scanner set = new Scanner(System.in);
        User user = new User();
        //用户名
       while(true){
           String username = set.next();
           if(!isexit(userlist,username) && islenvalid(username)&&isconvalid(username)){
               user.setUsername(username);
               System.out.println("用户名满足条件");
               break;
           }
           else{
               System.out.println("用户名不合法，请重新输入");
           }
       }
        //密码
        while (true) {
            System.out.println("输入密码");
            String password = set.next();
            System.out.println("请确认密码");
            String passwordcheck = set.next();
            if(password.equals(passwordcheck)){
                user.setPassword(password);
                break;
            }
            else{
                System.out.println("两次密码不一致");
            }
        }
        //身份证
        System.out.println("输入身份证号码");
        String idcard = set.next();
        verifyidcard(user,idcard);
        //手机号
        System.out.println("请输入手机号码");
        String phone = set.next();
        verifyphone(user,phone);
        if(userlist.add(user)){
            System.out.println("注册成功");

        }
    }
    //登录
    public static void login(ArrayList<User> userlist){
        Scanner set = new Scanner(System.in);
        User user = new User();
        System.out.println("请输入用户名");
        String username = set.next();
        if(isexit(userlist,username)){
            user.setUsername(username);
        }
        else{
            System.out.println("用户名未注册，请先注册");
            return;
        }
        System.out.println("请输入验证码");
        String vercode = code();
        System.out.println(vercode);
        while(true){
            String code = set.next();
            if(!code.equals(vercode)){
                System.out.println("验证码输入错误，请重新输入");
            }
            else{
                break;
            }
        }
        System.out.println("输入密码");
        String password = set.next();
        for (int i = 0; i < 3; i++) {
            if(ismatch(userlist,username,password)){
                System.out.println("登录成功");
                MainSystem ms = new MainSystem();
                ms.startSystem();
                break;
            }
            else{
                System.out.println("用户名或密码错误,剩余"+(2-i)+"次机会");
                System.out.println("请输入密码");
                password = set.next();
            }
        }

    }
    //忘记密码
    public static void forgetpsw(ArrayList<User> userlist){
        Scanner set = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = set.next();
        if(!isexit(userlist,username)){
            System.out.println("用户名不存在");
            return;
        }
        System.out.println("输入身份证和手机号码");
        String idcard = set.next();
        String phone = set.next();
        if(ismatch(userlist,username,idcard,phone)){
            int index = getIndex(userlist,username);
            System.out.println("输入密码进行修改");
            String password = set.next();
            userlist.get(index).setPassword(password);
            System.out.println("修改成功");
        }
        else{
            System.out.println("信息不匹配，修改失败");
        }

    }
    //判断用户名存在性
    public static boolean isexit(ArrayList<User> userlist,String username){
        return getIndex(userlist,username) >= 0;
    }
    //用户名长度合法性判断
    public static boolean islenvalid(String username){

        if(username.length()>=3 && username.length()<=15){
            return true;
        }
        else{
            return false;
        }
    }
    //用户名格式合法性判断
    public static boolean isconvalid(String username){
        for (int i = 0; i < username.length(); i++) {
            String tmp = username.toUpperCase();
            if(!(tmp.charAt(i)>='A'&&tmp.charAt(i)<='Z'||tmp.charAt(i)>='0'&&tmp.charAt(i)<='9')){
                return false;
            }
        }
        int charcount = 0;
        for (int i = 0; i < username.length(); i++) {
            if(username.charAt(i)>='a'&&username.charAt(i)<='z')
            {
                charcount++;
                break;
            }
        }
        return charcount > 0;

    }
    //身份证验证
    public static void verifyidcard(User user,String idcard){
        Scanner set = new Scanner(System.in);
        while(true){
            if(idcard.length()!=18){
                System.out.println("身份证长度出错，请重新输入");
                idcard = set.next();
            }
            else if(idcard.charAt(0) =='0'){  //boolean idcard.startWith("0")
                System.out.println("第一位不能为0，请重新输入");
                idcard = set.next();
            }
            else if(!idcheck(idcard)){
                System.out.println("身份证格式错误，请重新输入");
                idcard = set.next();
            }
            else{
                user.setIdcard(idcard);
                break;
            }
        }
    }
    //身份证格式合法性检测
    public static boolean idcheck(String idcard){
        for (int i = 0; i < idcard.length()-1; i++) {
            if(idcard.charAt(i)<'0' || idcard.charAt(i)>'9'){
                return false;
            }
        }
        char lastword = idcard.charAt(idcard.length()-1);
        if(!(lastword>='0' && lastword<='9' || lastword == 'x' || lastword == 'X')){
            return false;
        }
        return true;
    }
    //手机号验证
    public static void verifyphone(User user,String phone){
        Scanner set = new Scanner(System.in);
        while(true){
            if(phone.length()!=11){
                System.out.println("手机号长度出错，请重新输入");
                phone = set.next();
            }
            else if(phone.charAt(0) == '0'){
                System.out.println("首位不能为0，请重新输入");
                phone = set.next();
            }
            else if(!phonecheck(phone)){
                System.out.println("手机号格式出错，请重新输入");
                phone = set.next();
            }
            else{
                user.setPhone(phone);
                break;
            }

        }
    }
    //手机号合法性检测
    public static boolean phonecheck(String phone){
        for (int i = 0; i < phone.length(); i++) {
            if(phone.charAt(i)<'0' || phone.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }
    //验证码
    public static String code(){
        Random r = new Random();
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if(i<26){
                arr[i] = (char)('a'+i);
            }
            else{
                arr[i] = (char)('A'+i-26);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(arr[r.nextInt(arr.length)]);
        }
        sb.append(r.nextInt(10));
        String s = sb.toString();
        char[] str = s.toCharArray();
        //打乱顺序
        for (int i = 0; i < str.length; i++) {
            int index = r.nextInt(str.length);
            char tmp = str[index];
            str[index] = str[i];
            str[i] = tmp;
        }
        return new String(str);
    }
    //获取索引
    public static int getIndex(ArrayList<User>userlist,String username){
        for (int i = 0; i < userlist.size(); i++) {
            if(userlist.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
    //用户名密码匹配性判断
    public static boolean ismatch(ArrayList<User> userlist, String username,String password){
            int index = getIndex(userlist,username);
            if(userlist.get(index).getUsername().equals(username) && userlist.get(index).getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
    }
    // 修改密码一致性判断
    public static boolean ismatch(ArrayList<User> userlist,String username,String idcard,String phone){
        int index = getIndex(userlist,username);
        User user = userlist.get(index);
        if(user.getIdcard().equals(idcard) && user.getPhone().equals(phone)){
            return true;
        }
        else{
            return false;
        }
    }



}
