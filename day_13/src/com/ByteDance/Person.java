package com.ByteDance;

public class Person {
    private String name ;
    private String gender;
    private int age;
    private String nationality;
    public Person(){

    }

    public Person(String name, String gender, int age, String nationality) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void work(){
        System.out.println("工作");
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
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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

    /**
     * 获取
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String toString() {
        return "Person{name = " + name + ", gender = " + gender + ", age = " + age + ", nationality = " + nationality + "}";
    }
}
