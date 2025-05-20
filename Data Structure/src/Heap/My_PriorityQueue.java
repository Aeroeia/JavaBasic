package Heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;
public class My_PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public My_PriorityQueue() {
        heap = new ArrayList<>();
    }

    // 插入元素
    public void add(T item) {
        heap.add(item);            // 添加到堆的末尾
        swim(heap.size() - 1);      // 上浮操作
    }

    // 删除并返回最小元素
    public T poll() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);      // 将最后一个元素移到堆顶
            sink(0);                // 下沉操作
        }
        return min;
    }

    // 返回最小元素（不删除）
    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        return heap.get(0);
    }

    // 上浮操作
    private void swim(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;              // 若当前元素 >= 父元素，则停止上浮
            }
            swap(index, parent);
            index = parent;
        }
    }

    // 下沉操作
    private void sink(int index) {
        int n = heap.size();
        while (2 * index + 1 < n) {
            int child = 2 * index + 1;
            if (child + 1 < n && heap.get(child + 1).compareTo(heap.get(child)) < 0) {
                child++;            // 选择较小的子节点
            }
            if (heap.get(index).compareTo(heap.get(child)) <= 0) {
                break;              // 若当前元素 <= 子节点，则停止下沉
            }
            swap(index, child);
            index = child;
        }
    }

    // 交换元素
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 返回队列大小
    public int size() {
        return heap.size();
    }

    // 检查队列是否为空
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        My_PriorityQueue<Integer> pq = new My_PriorityQueue<>();
        pq.add(5);
        pq.add(3);
        pq.add(8);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // 输出：1, 3, 5, 8
        }
    }
}
