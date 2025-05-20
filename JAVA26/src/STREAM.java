import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class STREAM {
    //原来的流只能使用一次因此建议使用链式编程
    public static void main(String[] args) {
        ArrayList<Integer> ary = new ArrayList<>();
        for(int i = 0 ;i<10;i++){
            ary.add(i);
        }
        Stream<Integer> integerStream = ary.stream().filter(o -> o > 5);
        integerStream.forEach((o)-> System.out.println(o));

        System.out.println("--------------------");

        int[] arr = {1,2,3,4,5,6,7};
        Arrays.stream(arr).filter(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value>3;
            }
        }).forEach(o-> System.out.println(o));

        System.out.println("-----------------------");
        //limit 获取前几个数据

        ary.stream().limit(3).forEach(integer -> System.out.println(integer));

        System.out.println("---------------------");
        //skip

        ary.stream().skip(3).forEach(o-> System.out.println(o));

        //distinct 去重
        System.out.println("--------------------");

        ary.add(1);
        System.out.println(ary);
        ary.stream().distinct().forEach(o-> System.out.print(o+" "));
        System.out.println();

        //concat 合并两个流
        System.out.println("---------------------");
        Stream<Integer> stream1 = ary.stream().filter(o->o>7);
        Stream <Integer> stream2 = ary.stream().filter(o->o<3);
        Stream.concat(stream1,stream2).forEach(o-> System.out.print(o+" "));
        System.out.println();

        //类型转换 map
        System.out.println("-----------------------");
        ary.stream().map(s->String.valueOf(s)).forEach(System.out::println);

        //count 统计
        System.out.println("--------------------");
        System.out.println(ary.stream().count());

        //toArray
        System.out.println("-------------------------");
        Object[] array = ary.stream().toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("point1----------------------");
        System.out.println(Arrays.toString(ary.stream().toArray(val -> {
            System.out.println(val);
            return new Integer[val];
        })));
        System.out.println("point2---------------------");
        //收集到集合 collect
        System.out.println("------------------------------");
        List<Integer>l =  ary.stream().filter(o->o>5).collect(Collectors.toList());
        l.forEach(o-> System.out.println(o));

        //ary.stream().collect(Collectors.toMap())   Function第一个参数代表流中每一个数据的数据类型  第二个参数表示返回值类型
        // toMAp第一个参数表示键 第二个表示值

//        Map<Integer, Integer> collectMap = ary.stream().filter(o -> o > 5).collect(Collectors.toMap(new Function<Integer, Integer>() {
//                                                                                                     @Override
//                                                                                                     public Integer apply(Integer integer) {
//                                                                                                         return 0;
//                                                                                                     }
//                                                                                                 },
//                new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) {
//                        return 0;
//                    }
//                }));


        //练习
        System.out.println("------------------------");
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangsan,23","lisi,24","wangwu,25");
        Map<String, String> mp = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).collect(Collectors.toMap(
                k -> k.split(",")[0], v -> v.split(",")[1]
        ));
        System.out.println(mp);
    }

}
