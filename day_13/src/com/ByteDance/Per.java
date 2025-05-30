package com.ByteDance;

public class Per {
    private String name;
    private int age;
    public void keepPet(Dog dog,String something){
        System.out.printf("颜色为%s的%d岁的狗，在吃%s\n",dog.getColor(),dog.getAge(),something);
    }

    public Per() {
    }

    public Per(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String toString() {
        return "Per{name = " + name + ", age = " + age + "}";
    }
}
