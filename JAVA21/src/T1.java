import java.util.Arrays;

public class T1 {
    public static void main(String[] args) {
        Person p1 = new Person(18,"zhangsan",180);
        Person p2 = new Person(20,"zhangsan",180);
        Person p3 = new Person(18,"lisi",180);
        Person p4 = new Person(18,"lisi",181);
        Person[] arr = {p1,p2,p3,p4};
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,(o1,o2)->{
            if(o1.age!=o2.age){
                return o1.age>o2.age?-1:1;
            }
            else if(o1.height!=o2.height){
                return o1.height>o2.height?-1:1;
            }
            else{
//                int index = 0;
//                while(index<=o1.name.length()&&index<=o2.name.length()){
//                    if(o1.name.charAt(index)!=o2.name.charAt(index)){
//                        return o1.name.charAt(index)>o2.name.charAt(index)?1:-1;
//                    }
//                    index++;
//                }
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
class Person{
    public int age;
    public String name;
    public int height;

    public Person(){

    }
    public Person(int age, String name, int height){
        this.age = age;
        this.name = name;
        this.height = height;
    }
    @Override
    public String toString(){
        return "name:"+name+" age:"+age+" height:"+height;
    }
}