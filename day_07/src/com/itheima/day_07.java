package com.itheima;

import java.util.Random;
import java.util.Scanner;

/*
public class day_07 {
    public static void main(String[] args)
    {
     int[] arr = new int[6];
     Scanner set = new Scanner(System.in);
     for(int i = 0;i<arr.length;)
     {
         int score = set.nextInt();
         if(score>=0 && score<=100)
         {
             arr[i] = score;
             i++;
         }
     }
     int max  = arr[0];
     int min = arr[0];
     for(int i = 1;i<arr.length;i++)
     {
         if(arr[i]>max)
         {
             max = arr[i];

         }
     }
     for(int i = 1;i<arr.length;i++)
     {
         if(arr[i]<min)
         {
             min = arr[i];
         }
     }
     int sum = 0;
     for(int i = 0;i<arr.length;i++)
     {
         sum = sum+arr[i];
     }
     double ave = (sum-max-min)/(double)(arr.length-2);
     System.out.println(ave);
    }
}
*/
/*
public class day_07
{
    public static void main(String[] args)
    {
      int[] arr = new int[]{2,588,888,1000,10000};
        Random r = new Random();
        for(int i = 0;i<arr.length;i++)
        {
            int index = r.nextInt(arr.length);
            int tmp  = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }

}*/
//双色球
public class day_07
{
    public static void main(String[] args)
    {
        Random r = new Random();
        int[] red= new int[6];
        for(int i = 0;i<red.length;)
        {
            int flag = 0;
            int put = r.nextInt(33)+1;
            for(int j = 0;j<i;j++)
            {
                if(put == red[j])
                {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
            {
                red[i] = put;
                System.out.print(red[i]+" ");
                i++;
            }
        }
        int blue = r.nextInt(16)+1;
        System.out.println(blue);
        int[] myred = new int[red.length];
        Scanner set = new Scanner(System.in);
        for(int i = 0;i<red.length;i++)
        {
            myred[i] = set.nextInt();
        }
        int myblue = set.nextInt();
        int[] result = new int[2];
        check(result,myred,myblue,red,blue);
        firstPrize(result);
        secondPrize(result);
        thirdthPrize(result);
        forthPrize(result);
        fifthPrize(result);
        sixthPrize(result);
    }
    public static void check(int[] result,int[] myred,int myblue,int[] red,int blue)
    {
        for(int i = 0;i<myred.length;i++)
        {
            for(int j =0;j<red.length;j++)
            {
                if(myred[i] == red[j])
                {
                    result[0]++;
                }
            }
        }
        if(myblue == blue)
        {
            result[1]++;
        }
    }
    public static void firstPrize(int[] result)
    {
        if(result[0] == 6 && result[1] == 1)
        {
            System.out.println("恭喜中一等奖");
        }
    }
    public static void secondPrize(int[] result)
    {
        if(result[0]==6 && result[1] == 0)
        {
            System.out.println("中二等奖");
        }
    }
    public static void thirdthPrize(int[] result)
    {
        if((result[0]==5 && result[1]==1)||(result[0]==5 && result[1]==0))
            System.out.println("中三等奖");
    }
    public static void forthPrize(int[] result)
    {
        if((result[0]==4 && result[1]==1)||(result[0]==4&&result[1]==0))
            System.out.println("中四等奖");
    }
    public static void fifthPrize(int[] result)
    {
        if((result[0]==3 && result[1]==1)||(result[0]==2 &&result[1]==1))
            System.out.println("中五等奖");
    }
    public static void sixthPrize(int[] result)
    {
        if((result[0]==1 &&result[1]==1)||(result[0]==0 &&result[0]==1))
            System.out.println("中六等奖");
    }
}
