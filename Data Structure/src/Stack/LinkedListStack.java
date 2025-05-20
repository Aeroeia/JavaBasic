package Stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListStack<E> implements Iterable<E> {
    private int capacity;
    private int size;
    private Node<E> sen;

    public LinkedListStack(){
        this.capacity = 10;
        this.size = 0;
        this.sen = new Node<E>(null, null);
    }
    public LinkedListStack(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.sen = new Node<E>(null, null);
    }
    public boolean isEmpty(){
        return sen.next == null;
    }
    public boolean isFull(){
        return this.capacity==this.size;
    }
    public boolean push(E val){
        if(isFull()){
            return false;
        }
        sen.next = new Node<>(val,sen.next);
        size++;
        return true;
    }
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return sen.next.val;
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        Node<E> head = sen.next;
        sen.next = head.next;
        size--;
        return head.val;
    }
    static class Node<E>{
        E val;
        Node<E> next;
        public Node(E val,Node<E>next){
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sen.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

}
