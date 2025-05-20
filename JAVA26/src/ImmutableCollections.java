import java.util.*;

public class ImmutableCollections {
    public static void main(String[] args) {
        List<Integer> l = List.of(1,2,3,4,5,6);
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        HashMap<String,String> hm = new HashMap<>();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> stringStringEntry : hm.entrySet()) {
            
        }

    }

}
