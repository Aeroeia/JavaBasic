package Stack;

public class T {
    public static void main(String[] args){
        treeNode root = new treeNode(
                1,
                new treeNode(2,new treeNode(4),new treeNode(5)),
                new treeNode(3,new treeNode(6),new treeNode(7))
        );
        Solution.invertTree(root);
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

class Solution {
    public static treeNode invertTree(treeNode root) {
        if(root==null || (root.left ==null && root.right ==null)){
            return root;
        }
        //翻转左子树
        treeNode left = invertTree(root.left);
        //翻转右子树
        treeNode right= invertTree(root.right);
        //左右子树交换位置~
        root.left = right;
        root.right = left;
        return root;
    }
}