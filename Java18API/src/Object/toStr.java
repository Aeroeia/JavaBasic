package Object;

public class toStr {
    public static void main(String[] args) {
        Base b = new Base();
        System.out.println(b);
    }
}
class Base{
    public int age;
    public String name;
    @Override
    public String toString() {
        return new String("name:"+this.name+" age:"+this.age);
    }
}

