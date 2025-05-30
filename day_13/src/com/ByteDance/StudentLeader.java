package com.ByteDance;

public class StudentLeader extends Student{
    private String job;

    public StudentLeader(String name, String gender, int age, String nationality, String school, String stuNumber, String job) {
        super(name, gender, age, nationality, school, stuNumber);
        this.job = job;
    }

    public StudentLeader(){

    }
    public void meeting(){
        System.out.println("开会");
    }
}
