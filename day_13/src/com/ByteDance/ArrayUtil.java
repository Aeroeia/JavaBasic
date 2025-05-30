package com.ByteDance;

import java.util.StringJoiner;

public class ArrayUtil {
    private ArrayUtil(){

    }
    public static String printArray(int[] arr){
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i]+"");
        }
        return sj.toString();
    }
    public static double getAerage(double[] arr){
        double ave = 0;
        for (int i = 0; i < arr.length; i++) {
            ave = ave + arr[i];
        }
        return ave/arr.length;
    }
}

