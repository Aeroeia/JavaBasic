package com.itheima;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args)
    {
        Car[] arr = new Car[3];
        Scanner set = new Scanner(System.in);
       for(int i = 0;i<arr.length;i++)
       {
           Car car = new Car();
           String brand = set.next();
           double price = set.nextDouble();
           String color = set.next();
           car.setBrand(brand);
           car.setPrice(price);
           car.setColor(color);
           arr[i]  = car;
       }
       for(int i = 0;i<arr.length;i++)
       {
           System.out.print(arr[i].getBrand()+" "+arr[i].getColor()+" "+arr[i].getPrice());
           System.out.println();
       }
        
    }
}
