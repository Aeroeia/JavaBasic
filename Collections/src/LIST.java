import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LIST {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<10;i++){
            l.add(i+1);
        }
        //列表迭代器 额外添加了add方法
        ListIterator lit = l.listIterator();
        while(lit.hasNext()){
            System.out.println(lit.next());
            lit.remove();
        }
    }
}
