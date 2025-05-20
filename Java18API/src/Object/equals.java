package Object;

public class equals {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = new String("a");
        //System.out.println(s1.equals(s2));

        T t1 = new T(10);
        T t2 = new T(10);
        System.out.println(t1.equals(t2)); // true

    }
}
class T{
    public int age;
    public T(int age){
        this.age = age;

    }
    @Override
    public boolean equals(Object obj){
        T t = (T)obj;
       return this.age == t.age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        T t = (T) o;
//        return age == t.age;
//    }


}