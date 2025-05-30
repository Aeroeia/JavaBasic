package com.itheima;

import java.util.Scanner;

public class Studentpractice {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Scanner set = new Scanner(System.in);
        int i = 0;
        for (i = 0; i < arr.length - 1; i++) {
            Student stu = new Student();
            System.out.println("输入学生学号");
            stu.setNum(set.nextLong());
            System.out.println("请输入学生姓名");
            stu.setName(set.next());
            System.out.println("请输入学生年龄");
            stu.setAge(set.nextInt());
            arr[i] = stu;
        }
        System.out.println("添加一个学生信息");
        Student stu = new Student();
        System.out.println("请输入学生学号");
        boolean flag = true;
        while (flag) {
            long num = set.nextLong();
            for (int j = 0; j <= i; j++) {
                if (num != arr[j].getNum()) {
                    stu.setNum(num);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("该学号已存在，请重新输入");
            }
        }
        System.out.println("请输入学生姓名");
        stu.setName(set.next());
        System.out.println("请输入学生年龄");
        stu.setAge(set.nextInt());
        arr[i] = stu;
        for (int j = 0; j <= i; j++) {
            System.out.printf("学号:%d 姓名:%s 年龄:%d\n", arr[j].getNum(), arr[j].getName(), arr[j].getAge());
        }
        System.out.println("删除一个学生信息");
        System.out.println("输入该学生学号");
        long num = set.nextLong();
        boolean tip = true;
        for (int j = 0; j <= i; j++) {
            if (arr[j].getNum() == num) {
                arr[j] = arr[i];
                i--;
                tip = false;
                break;
            }
        }
        if (tip) {
            System.out.println("该学生学号不存在");
        }
        for (int j = 0; j <= i; j++) {
            System.out.printf("学号:%d 姓名:%s 年龄:%d\n", arr[j].getNum(), arr[j].getName(), arr[j].getAge());
        }
        System.out.println("查询");
        long numble = set.nextInt();
        for (int j = 0; j <= i; j++) {
            if (arr[j].getNum() == numble) {
                arr[j].setAge(arr[j].getAge() + 1);
                System.out.printf("学号:%d 姓名:%s 年龄:%d\n", arr[j].getNum(), arr[j].getName(), arr[j].getAge());
                break;
            }
        }

    }
}
