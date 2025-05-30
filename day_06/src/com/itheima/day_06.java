package com.itheima;

import java.util.Random;

/*public class day_06 {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8};
        Scanner set = new Scanner(System.in);
        int from = set.nextInt();
        int to  = set.nextInt();
        int value = set.nextInt();
        fill(arr,from,to,value);
        for(int i = 0;i<arr.length;i++)
        {
            System.out.printf("%d ",arr[i]);
        }
    }
    public static void fill(int[] arr,int from, int to,int value)
    {
        if(from>=0 && to<arr.length && from<=to){
            for(int i = from;i<=to;i++)
            {
                arr[i] = value;
            }
        }
        else{
            System.out.println("输入错误");
        }
    }
}
*/
public class day_06
{
    public static void main(String[] args)
    {
        int[] arr = {2,588,888,1000,10000};
        Random r = new Random();
        int right = arr.length-1;
        for(int i = 0;i<arr.length;i++)
        {
            int ret = r.nextInt(right+1);
            System.out.println(arr[ret]+"元的奖金被抽出");
            arr[ret] = arr[right];
            right--;
        }
    }
}