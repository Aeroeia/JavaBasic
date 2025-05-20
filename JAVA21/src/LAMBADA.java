import java.util.Arrays;

public class LAMBADA {
    public static void main(String[] args) {
        Integer[] arr = {2,1,3,7,5,6,8,4,9};
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
        //Lambda
        Arrays.sort(arr,(Integer o1,Integer o2)->{
            return o1-o2;
        });
        System.out.println(Arrays.toString(arr));

        method(()->{
            System.out.println("游泳");
        });

        //Lambda省略写法
        method(()->System.out.println("a"));

        Arrays.sort(arr,(o1,o2)->o1-o2);

    }
    public static void method(Swim s){
        s.swim();
    }
}
@FunctionalInterface
interface  Swim{
    public abstract void swim();
}
