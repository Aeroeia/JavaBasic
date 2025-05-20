import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class COLLECTION {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<Integer>();
        for(int i = 0;i<10;i++){
            col.add(i);
        }

       // iteratormethod(col);

        //formethod(col);

        col.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Lambda表达式
        col.forEach(s-> System.out.println(s));

    }
    //增强for遍历 用于集合或数组
    private static void formethod(Collection<Integer> col) {
        for(Integer i : col){
            System.out.println(i);
        }
    }

    //迭代器遍历
    private static void iteratormethod(Collection<Integer> col) {
        Iterator<Integer> it = col.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
