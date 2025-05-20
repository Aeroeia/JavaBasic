package Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Iterable{
    private E[] arr;
    private int top;

    public ArrayStack(){
        this.top  = 0;
        this.arr = (E[]) new Object[10];
    }
    public boolean isEmpty(){
        return this.top==0;
    }
    public boolean isFull(){
        return (top+1)==arr.length;
    }
    public boolean push(E val){
        if(isFull()){
            return false;
        }
        arr[top++] = val;
        return true;
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        return arr[top--];
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p>0;
            }

            @Override
            public E next() {
                E val = arr[p-1];
                p--;
                return val;
            }
        };
    }
}
