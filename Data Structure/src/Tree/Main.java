package Tree;

public class Main {
    public static void main(String[] args) {
       RedBlackTree rbt = new RedBlackTree();
       for(int i = 0;i<10;i++){
           rbt.put(i,i);
       }
       rbt.print();
    }
}
