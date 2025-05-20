package System;

public class ArrayCopy {
    public static void main(String[] args) {
        //test();
        //子类可以赋值给父类
        Student[] stuarr = new Student[3];
        for(int i = 0;i<stuarr.length;i++){
            Student s = new Student(10+i,"学生"+(i+1));
            stuarr[i] = s;
        }
        Person[] perarr = new Person[stuarr.length];
        System.arraycopy(stuarr,0,perarr,0,stuarr.length);
        for(int i = 0;i<perarr.length;i++){
            System.out.println(perarr[i].getName());
        }
    }

    private static void test() {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        for(int i = 0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1,0,arr3,4,3);
        for(int i = 0;i<arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
    }
}

class Person{
    private  int age;
    private String name;
    public Person(){

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Student extends Person{
    public Student() {
    }

    public Student(int age, String name) {
        super(age, name);
    }
}