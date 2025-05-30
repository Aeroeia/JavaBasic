package System;

import java.util.ArrayList;

public class A {
     public static void main(String[] args){
         ArrayList<Student> stu = new ArrayList<>();
         test(stu);
         System.out.println(stu.get(0).getAddress());
     }
     public static void test(ArrayList<Student> stu){
         Student s = new Student(1,"zhangsan",18,"a");
         stu.add(s);
     }

}


