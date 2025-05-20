import java.util.Stack;

public class ExpressionTree {
    public static void main(String[] args) {
        String[] tokens = {"2","1","-","3","*"};
        treeNode root = setTree(tokens);
        print(root);
    }
    public static treeNode setTree(String[] tokens) {
        Stack<treeNode> stack = new Stack<>();
        for(String str: tokens){
            switch (str){
                case "+","-","*","/"->{
                    treeNode right = stack.pop();
                    treeNode left =  stack.pop();
                    treeNode root = new treeNode(str);
                    root.left = left;
                    root.right = right;
                    stack.push(root);
                }
                default -> {
                    stack.push(new treeNode(str));
                }
            }
        }
        return stack.pop();
    }
    public static void print(treeNode root){
        if(root==null){
            return;
        }
        print(root.left);
        print(root.right);
        System.out.print(root.val+" ");
    }
    private  static class treeNode {
        String val;
        treeNode left;
        treeNode right;
        public treeNode(String val){
            this.val = val;
        }
    }

}
