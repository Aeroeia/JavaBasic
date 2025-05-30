package com.itheima;

import java.util.Scanner;

/*public class practice2 {
    public static void main(String[] args)
    {
         //7和7的倍数
        for(int i = 0; i <1000;i++)
        {
            int j = i;
            while(j>0)
            {
                if(j%10==7 || j%7==0)
                {
                    System.out.println(i);
                }
                j/=10;
            }
        }
       // Random r = new Random();
        //double num = r.nextDouble(100); // 0~100
       // System.out.println(num);
        //猜数字
        Random r = new Random();
        Scanner set = new Scanner(System.in);
        int num = r.nextInt(91);
        do {
            int ans = set.nextInt();
            if (ans > num)
                System.out.println("猜大了");
            else if (ans < num)
                System.out.println("猜小了");
            else {
                System.out.println("猜中了");
                break;
            }

            }
            while (true) ;
        }
}
public class practice2
{
    public static void main(String[] args)
    {
        //int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr = new int[10];
        int len = arr.length;
        //for(int i=0;i<len;i++)
        //{
         //   System.out.println(arr[i]);
       // }
        System.out.println(len);
    }
}
//最值
public class practice2
{
    public static void main(String[] args)
    {
        Scanner set = new Scanner(System.in);
        int[] arr = new int[5];
        int n  = arr.length;
        for(int i = 0;i<n;i++)
        {
            arr[i] = set.nextInt();
        }
        int max = arr[0];
        for(int i = 1;i<n;i++)
        {
            if(arr[i]>max)
                max = arr[i];
        }
        System.out.println(max);
    }
}
public class practice2
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        Random num = new Random();
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = num.nextInt(100)+1;
        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println("arr"+i+"="+arr[i]);
        }
        int sum = 0;
        double ave = 0.0;
        for(int i = 0;i<arr.length;i++)
        {
            sum = sum+arr[i];
        }
        int flag = 0;
        ave = (double)sum/arr.length;
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i]<ave)
                flag++;
        }
        System.out.println("sum = "+sum);
        System.out.println("ave = "+ave);
        System.out.println("flag = "+flag);
    }
}
//逆置
public class practice2
{
    public static void main(String[] args)
    {
        int[] arr = new int[5];
        Scanner set = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = set.nextInt();
        }
        int left = 0;
        int right = arr.length-1;
        while(left<right)
        {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}

public class practice2
{
    public static void main(String[] args)
    {
        Scanner set = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = set.nextInt();
        }
        int right = arr.length-1;
        int num = 0;
        while(right>=0)
        {
            num = num*10+arr[right];
            right--;
        }
        System.out.println(num);
    }
}
public class practice2
{
    public static void main(String[] args)
    {
        int[] arr = {12,14,23,45,50,66,68,70,77,90,91};
        Scanner set = new Scanner(System.in);
        int n = set.nextInt();
        for(int i = 0;i<arr.length-1;i++)
        {
            for(int j = 0;j<arr.length-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        int j = 0;
        int flag = 0;
        int[] str = new int[arr.length+1];
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i]<n)
            {
                str[i] = arr[i];
                flag = i+1;
            }
            else {
                str[i+1] = arr[i];
            }
            str[flag] = n;
        }
        for(int i = 0;i<arr.length+1;i++)
        {
            System.out.printf("%d ",str[i]);
        }
    }
}*/
public class practice2
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        Scanner set = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = set.nextInt();
        }
        int right = arr.length-1;
        int left = 0;
        int[] str = new int[arr.length];
        for(int i = 0;i<arr.length;i++)
        {

            if(arr[i]%2==1)
            {
                str[left] = arr[i];
                left++;
            }
            else {
                str[right] = arr[i];
                right--;
            }

        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.printf("%d ",str[i]);
        }
    }
}