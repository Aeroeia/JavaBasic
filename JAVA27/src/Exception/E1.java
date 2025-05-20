package Exception;

public class E1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(16);
        System.out.println(s1.getAge());

        int[] arr = {1,2,3,4,5,6,7,8};
        try{
            System.out.println(arr[10]);//不会执行下面try代码
            System.out.println(3/0);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


    }
}
