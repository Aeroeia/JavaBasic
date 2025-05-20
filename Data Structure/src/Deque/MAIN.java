package Deque;

public class MAIN {
    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 0;i<10;i++){
            ad.offerLast(i);
        }
        int size = ad.size;
        for(int i = 0;i<size;i++){
            System.out.println(ad.pollFirst());
        }
    }
}
