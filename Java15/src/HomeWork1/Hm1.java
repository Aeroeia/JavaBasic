package HomeWork1;

import java.util.LinkedList;
import java.util.Queue;

public class Hm1 {
        public static void main(String[] args){
            Queue<treeNode> q = new LinkedList<treeNode>();
            treeNode root = new treeNode(
                    1,
                    new treeNode(2,new treeNode(4),new treeNode(5)),
                    new treeNode(3,new treeNode(6),new treeNode(7))
            );
            q.offer(root);
            int c1 = 1;
            while(!q.isEmpty()){
              int c2 = 0;
              for(int i = 0;i<c1;i++){
                  treeNode t =  q.poll();
                  System.out.print(t.val+" ");
                  if(t.left!=null){
                      q.offer(t.left);
                      c2++;
                  }
                  if(t.right!=null){
                      q.offer(t.right);
                      c2++;
                  }
              }
                c1=c2;
                System.out.println();
            }
        }
}
class treeNode{
    public int val;
    public treeNode left;
    public  treeNode right;
            public treeNode(){

            }
            public treeNode(int val){
                this.val = val;
            }
            public treeNode(int val,treeNode left,treeNode right){
                this.left = left;
                this.right = right;
                this.val = val;
            }
}

