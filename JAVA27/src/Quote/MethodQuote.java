package Quote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MethodQuote {
    public static void main(String[] args) {
        //引用处是函数式接口
        //被引用方法的形参跟返回值跟抽象方法保持一致
        Integer[] arr = {3,1,2,4,6,5,7,9,8,10};
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        Arrays.sort(arr,MethodQuote::subtraction);


        ArrayList<String> ary = new ArrayList<>();
        Collections.addAll(ary,"1","2","3","4");
//        ary.stream().map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        }).forEach(System.out::println);

        ary.stream().map(s->Integer.parseInt(s));


        ary.stream().map(Integer::parseInt).forEach(System.out::println);



        //类引用 抽象方法第一个参数限制类的类别 该stream流中数据类型为String因此类引用只能使用String类
        // toUpperClass无参数  抽象方法第二个参数为类引用中方法的第一个参数 没有第二个参数则调用默认方法
        ArrayList<String> str = new ArrayList<>();
        Collections.addAll(str,"a","b","c","d");
        str.stream().map(String::toUpperCase).forEach(System.out::println);

         //引用数组构造方法
        ArrayList<Integer> arr2 = new ArrayList<>();
        Collections.addAll(arr2,1,2,3,4,5,6,7,8,9);
        Integer[] array = arr2.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));

        //引用静态方法： 类名::方法名
        //成员方法： new 类::方法名 本类：this::方法名 父类：super::方法名
        //构造方法 类名::new
        //数组构造方法 数据类型[]::new

    }
    public static int subtraction(int v1,int v2){
        return v2-v1;
    }
}
