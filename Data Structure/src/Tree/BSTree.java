package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTree {

    Node root;

    static class Node{
        int key;
        Object val;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int key, Object val){
            this.key = key;
            this.val = val;
        }
        public Node(int key,Object val,Node left,Node right){
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node get(int key){
        return doGet(root,key);
    }
    private Node doGet(Node root,int key){
        if(root == null){
            return null;
        }
        if(key>root.key){
            return doGet(root.right,key);
        }
        else if(key<root.key){
            return doGet(root.left,key);
        }
        else{
            return root;
        }
    }

    public Object min(){
       return domin(root);
    }
    private Object domin(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null){
            return root.val;
        }
        return domin(root.left);
    }

    public Object max(){
        return doMax(root);
    }
    private Object doMax(Node root){
        if(root == null){
            return null;
        }
        if(root.right == null){
            return root.val;
        }
        return doMax(root.right);
    }
    public void put(int key,Object val){
        doPut(root,key,val);
    }
    private void doPut(Node root,int key,Object val){
        if(root == null){
            this.root = new Node(key,val);
            return;
        }
        if(key>root.key){
            if(root.right==null){
                root.right = new Node(key,val);
                return;
            }
            doPut(root.right,key,val);
        }
        else if(key<root.key){
            if(root.left==null){
                root.left = new Node(key,val);
                return;
            }
            doPut(root.left,key,val);
        }
        else{
            root.val = val;
        }
    }
    public Object successor(int key){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        Node pop = null;
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.peek().key==key&&pop!=null){
                    return pop.val;
                }
                pop = stack.pop();
                root = pop.right;
            }
        }
        return null;
    }
    public Object predecessor(int key){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                Node pop = stack.pop();
                if(pop.key==key&&!stack.isEmpty()){
                    return stack.peek().val;
                }
                root = pop.right;
            }
        }
        return null;
    }
    public Object delete(int key) {
        if (this.root == null) {
            return null;
        }

        // 寻找要删除的节点及其父节点
        Node parent = null;
        Node curr = this.root;

        // 遍历寻找节点
        while (curr != null && curr.key != key) {
            parent = curr;
            if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // 如果找不到目标节点，直接返回 null
        if (curr == null) {
            return null;
        }

        // 如果删除的是叶子节点
        if (curr.left == null && curr.right == null) {
            if (parent == null) {
                this.root = null; // 删除的是根节点
            } else if (parent.left == curr) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // 如果删除的节点只有一个右子节点
        else if (curr.left == null) {
            if (parent == null) {
                this.root = curr.right; // 删除的是根节点
            } else if (parent.left == curr) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        }
        // 如果删除的节点只有一个左子节点
        else if (curr.right == null) {
            if (parent == null) {
                this.root = curr.left; // 删除的是根节点
            } else if (parent.left == curr) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        }
        // 如果删除的节点有两个子节点
        else {
            // 找到后继节点（右子树中最小节点）
            Node successorParent = curr;
            Node successor = curr.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // 替换值
            curr.key = successor.key;
            curr.val = successor.val;

            // 删除后继节点
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        return curr.val;
    }


    public void print(){
        doPrint(root);
        System.out.println();
    }
    private void doPrint(Node root){
        if(root==null){
            return;
        }
        doPrint(root.left);
        System.out.print(root.val+" ");
        doPrint(root.right);
    }
    public List<Object> less(int key){
        List<Object> list = new ArrayList<>();
        doless(root,list,key);
        return list;
    }
    private void doless(Node root,List<Object> list,int key){
        if(root==null){
            return;
        }

        doless(root.left,list,key);
        if(key<=root.key){
            return;
        }
        list.add(root.val);
        doless(root.right,list,key);

    }
    public List<Object> greater(int key){
        List<Object> list = new ArrayList<>();
        dogreater(root,list,key);
        return list;
    }
    private void dogreater(Node root,List<Object> list,int key){
        if(root==null){
            return;
        }
        dogreater(root.right,list,key);
        if(root.key<=key){
            return;
        }
        list.add(root.val);
        dogreater(root.left,list,key);
    }
    public List<Object> between(int key1,int key2){
        List<Object> list = new ArrayList<>();
        dobetween(root,list,key1,key2);
        return list;
    }
    private void dobetween(Node root,List<Object> list,int key1,int key2){
        if(root==null){
            return;
        }
        dobetween(root.left,list,key1,key2);
        if(root.key>key1&&root.key<key2){
            list.add(root.val);
        }

        dobetween(root.right,list,key1,key2);
    }
    public void preorder(){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                System.out.print(root.val+" ");
                stack.push(root);
                root = root.left;
            }
            else{
                Node pop = stack.pop();
                root = pop.right;
            }
        }
        System.out.println();
    }
    public void inorder(){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                Node pop = stack.pop();
                System.out.print(pop.val+" ");
                root = pop.right;
            }
        }
        System.out.println();
    }
    public void postorder(){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        Node pop = null;
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                Node peek = stack.peek();
                if(peek.right==null||pop==peek.right){
                    pop = stack.pop();
                    System.out.print(pop.val+" ");
                }
                else{
                    root = peek.right;
                }

            }
        }
        System.out.println();
    }


}
