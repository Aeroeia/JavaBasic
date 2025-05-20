import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class HASHMAP {
    public static void main(String[] args) {
//        HashMap<Student,String> hm = new HashMap<>();
//        Student s1 = new Student(18,"zhangsan");
//        Student s2 = new Student(19,"lisi");
//        Student s3 = new Student(20,"wangwu");
//        Student s4 = new Student(21,"ahaoliu");
//        hm.put(s1,"s1");
//        hm.put(s2,"s2");
//        hm.put(s3,"s3");
//        hm.put(s4,"s4");
//        hm.forEach((stu,str)->{
//            System.out.println(stu+" "+str);
//        });


        String str = "abbaaaaesadafseabca";
        TreeMap<Character,Integer> hm = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        for(int i =0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                int count = hm.get(str.charAt(i));
                count++;
                hm.put(str.charAt(i),count);
            }
            else{
                hm.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    private static class Student{
        public int age;
        public String name;
        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
