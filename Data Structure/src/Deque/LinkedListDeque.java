package Deque;

import java.util.Iterator;

public class LinkedListDeque<E> implements Iterable<E> {
    private Node<E> sentinel = new Node<E>(null,null,null);
    int size;
    public LinkedListDeque(){
        this.size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void offerLast(E e){
        Node<E> newNode = new Node<>(e,sentinel.prev,sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
    public void offerFirst(E e){
        Node<E> newNode = new Node<>(e,sentinel,sentinel.next);
        sentinel.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }
    public E pollFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> remove = sentinel.next;
        sentinel.next = remove.next;
        remove.next.prev = sentinel;
        size--;
        return remove.val;
    }
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        Node<E> remove = sentinel.prev;
        remove.prev.next = sentinel;
        sentinel.prev = remove.prev;
        size--;
        return remove.val;
    }
    public void print(){
        Node<E> p = sentinel.next;
        while(p!=sentinel){
            System.out.println(p.val);
            p = p.next;
        }
    }
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return !(p==sentinel);
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }
}
class Node<E>{
    Node<E> next;
    E val;
    Node<E> prev;
    public Node(E val, Node<E> prev, Node<E> next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public Node(){
    }
}