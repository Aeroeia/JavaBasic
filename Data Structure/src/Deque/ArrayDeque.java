package Deque;

public class ArrayDeque<E> {
    public int size;
    private E[] arr;
    private int head;
    private int tail;
    private int capacity;

    public ArrayDeque() {
        this.size = 0;
        this.arr = (E[]) new Object[10];
        this.head = -1;
        this.tail = 0;
        this.capacity = 10;
    }

    public void offerFirst(E val) {
        if (isFull()) {
            resize();
        }
        head = (head + 1) % capacity;
        arr[head] = val;
        size++;
    }

    public void offerLast(E val) {
        if (isFull()) {
            resize();
        }
        tail = (tail - 1 + capacity) % capacity;
        arr[tail] = val;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E val;
        if(head==-1){
            head = capacity-1;
            val = arr[head];
        }
        else{
            val = arr[head];
            head = (head - 1 + capacity) % capacity;
        }
        size--;
        return val;
    }

    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        E val = arr[tail];
        tail = (tail + 1) % capacity;
        size--;
        return val;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        E[] newArr = (E[]) new Object[newCapacity];

        // 复制元素到新数组
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(tail + i) % capacity];
        }

        arr = newArr;
        tail = 0;
        head = size - 1;
        capacity = newCapacity;
    }
}

