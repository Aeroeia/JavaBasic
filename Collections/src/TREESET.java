import java.util.Comparator;
import java.util.TreeSet;

public class TREESET {
    public static void main(String[] args) {
//        String root = "学生";
//        TreeSet<Student> ts = new TreeSet<>();
//        for(int i = 1;i<=3;i++){
//            String name = root+i;
//            ts.add(new Student(i,name));
//        }
//        Iterator<Student> it = ts.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }



        String[] strarr = {"aa","abc","efgg","abcde"};
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.length()-o2.length();
                i = i==0?o1.compareTo(o2):i;
                return i;
            }
        });
        for(int i = 0;i<strarr.length;i++) {
            ts.add(strarr[i]);
        }
        for(String i : ts){
            System.out.println(i);
        }
    }
    private static class Student implements Comparable<Student>{
        public int age;
        public String name;
        public Student(){

        }
        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            return this.age - o.age;
        }
    }


}
