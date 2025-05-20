import java.util.*;
import java.util.function.BiConsumer;

public class MAP {
    public static void main(String[] args) {
        Map<Integer,String> mp = new HashMap<>();
        String root = "T";
        for(int i = 0;i<3;i++){
            mp.put(i,root+i);
        }
        //遍历key
        Set<Integer> keys = mp.keySet();
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //遍历val;
        Collection<String> val = mp.values();
        Iterator<String> it2 = val.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        //获取键值对对象
        Set<Map.Entry<Integer,String>> entries = mp.entrySet();
        for(Map.Entry<Integer,String> entry : entries){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }
        System.out.println(mp.get(1));

        mp.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer);
                System.out.println(s);
            }
        });
    }
}
