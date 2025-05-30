package com.ByteDance;

import java.util.ArrayList;

public class PhonePra {
    public static void main(String[] args){
        ArrayList<Phone> phone = new ArrayList<>();
        Phone[] s = new Phone[3];
        Phone s1 = new Phone();
        Phone s2 = new Phone();
        Phone s3 = new Phone();
        s1.setBrand("小米");
        s1.setPrice(1000);
        s2.setBrand("苹果");
        s2.setPrice(8000);
        s3.setBrand("锤子");
        s3.setPrice(2999);
        s[0] = s1;
        s[1] = s2;
        s[2] = s3;
        for (int i = 0; i < s.length; i++) {
            phone.add(s[i]);
        }
        ArrayList<Phone> ph = inFo(phone);
        for (int i = 0; i < ph.size(); i++) {
            System.out.print(ph.get(i).getBrand()+' '+ph.get(i).getPrice());
            System.out.println();
        }

    }
    public static ArrayList<Phone> inFo(ArrayList<Phone> phone){
        ArrayList<Phone> ph = new ArrayList<>();
        for (int i = 0; i < phone.size(); i++) {
            if(phone.get(i).getPrice()<3000){
                ph.add(phone.get(i));
            }
        }
        return ph;
    }
}
