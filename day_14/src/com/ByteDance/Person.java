package com.ByteDance;

public class Person {
    private String name;
    private int age;
    public void keepPet(Animal a,String sth){
        a.eat(sth);
        if(a instanceof Dog d){
            d.lookHome();
        }
        else if(a instanceof Cat c){
            c.catchMouse();
        }
        else{
            System.out.println("没有这个类型");
        }
    }

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{name = " + name + ", age = " + age + "}";
    }
}
