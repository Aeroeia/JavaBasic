package com.itheima;

import java.util.Scanner;

public class Phonepractice {
    public static void main(String[] args)
    {
        Scanner set = new Scanner(System.in);
        Phone[] arr = new Phone[3];
        for(int i = 0;i<3;i++)
        {
            Phone phone = new Phone();
            String brand = set.next();
            double price = set.nextDouble();
            String color = set.next();
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setColor(color);
            arr[i] = phone;
        }
        double sum = 0;
        for(int i = 0;i<3;i++)
        {
            sum = sum+arr[i].getPrice();
        }
        double ave = sum/arr.length;
        System.out.println(ave);
    }


}
