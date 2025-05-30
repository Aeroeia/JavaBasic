package com.itheima;

public class Student {
    private long num;
    private String name;
    private int age;

    public Student() {
    }

    public Student(long num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return num
     */
    public long getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(long num) {
        this.num = num;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }


}
