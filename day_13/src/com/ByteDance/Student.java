package com.ByteDance;

public class Student extends Person {
    private String school;
    private String stuNumber;
    public Student(){

    }

    public Student(String name, String gender, int age, String nationality, String school, String stuNumber) {
        super(name, gender, age, nationality);
        this.school = school;
        this.stuNumber = stuNumber;
    }

    @Override
    public void work(){
        System.out.println("学习");
    }
    public void test(){
        System.out.println("测试");
    }
}
