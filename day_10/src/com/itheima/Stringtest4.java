package com.itheima;

import java.util.Scanner;

public class Stringtest4 {
    public static void main(String[] args){
        Scanner set = new Scanner(System.in);
        int money = 0;
        //确保输入有效性
        while(true){
            int num = set.nextInt();
            if(num>=0 && num<=9999999){
                money = num;
                break;
            }
            else{
                System.out.println("输入金额无效,重新输入");
            }
        }
        //设置对应的表
        char[] arr = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        //设置索引
        int[] index = new int[10];
        int count = 0;
        int k = 0;
        while(money>0){
            index[k] = money%10;
            money /=10;
            k++;
            count++;
        }
        //将money转为中文
        String chinese = revert(arr,index,count);
        //在前面补零
        int add  = 7-count;
        for (int i = 0; i < add; i++) {
            chinese = "零"+chinese;
        }
        //插入单位
        String[] str = {"佰","拾","万","仟","佰","拾","元"};
            String result = "";
        for (int i = 0; i < 7; i++) {
            result =result+chinese.charAt(i)+str[i];
        }
        chinese = result;
        System.out.println(chinese);

    }
    public static String revert(char[] arr , int[] index,int count){
        String s = "";
        for (int i = count-1; i >= 0; i--) {
            s = s+arr[index[i]];
        }
        return s;
    }
}
