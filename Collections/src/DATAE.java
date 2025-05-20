import java.util.ArrayList;

public class DATAE {
    public static void main(String[] args) {
        


    }
    //?extends 表示可以传递E或者E的子类类型
    //?super 表示可以传递E或者E的父类类型
    public static void t(ArrayList<?extends Integer> ary){
        System.out.println(1);
    }
}
class MyArrayList<E>{
    Object[] obj = new Object[10];
    int size = 0;
    public void add(E e){
        obj[size] = e;
        size++;
    }
    public E get(int index){
        return (E)obj[index];
    }

    //泛型方法
    public<V> V t(V val){
        return val;
    }
}