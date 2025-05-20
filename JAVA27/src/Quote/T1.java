package Quote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//集合存储字符串数据
//收集到Student类型的数组
public class T1 {
    public static void main(String[] args) {
        ArrayList<String> ary = new ArrayList<>();
        Collections.addAll(ary,"张无忌,15","周芷若,14","张强,20","找敏,13","张三丰,100");
//        Student[] stuarr = ary.stream().map(s -> new Student(s)).toArray(Student[]::new);
        Student[] stuarr = ary.stream().map(Student::new).toArray(Student[]::new);
        System.out.println(Arrays.toString(stuarr));
        System.out.println("---------------------------");
        List<Student> stuary = ary.stream().map(Student::new).collect(Collectors.toList());
        String[] array = stuary.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.name;
            }
        }).toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
    private static class Student{
        public String name;
        public int age;
        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Student(String str){
            this.name = str.split(",")[0];
            this.age = Integer.parseInt(str.split(",")[1]);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
