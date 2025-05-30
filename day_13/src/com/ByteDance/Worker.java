package com.ByteDance;

public class Worker extends Person {
    private String unit;
    private int workAge;

    public Worker(String name, String gender, int age, String nationality, String unit, int workAge) {
        super(name, gender, age, nationality);
        this.unit = unit;
        this.workAge = workAge;
    }

    public Worker(){

    }
    @Override
    public void work(){
        System.out.println("盖房子");
    }
}
