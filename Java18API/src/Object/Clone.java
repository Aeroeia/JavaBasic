package Object;

import java.util.Arrays;

public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        User u1 = new User(10,"zhangsan",data);
        User u2 = (User)u1.clone();
        u1.getData()[0] = 10;
        System.out.println(u1);
        System.out.println(u2);

    }
}
class User implements  Cloneable{
    private int age;
    private String name;
    private int[] data;

    public User(int age, String name, int[] data) {
        this.age = age;
        this.name = name;
        this.data = data;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User u = (User)super.clone();
        int[] data = new int[this.data.length];
        System.arraycopy(this.data, 0, data, 0, this.data.length);
        u.data = data;
        return u;
    }
}