package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class RedBlackTree {
    Node root;
    enum Color{
        Red,
        Black;
    }
    static class Node{
        int key;
        Object val;
        Node parent;
        Node left;
        Node right;
        Color color = Color.Red;

        boolean isLeftChild(){
           return parent!=null&&parent.left==this;
        }
        Node uncle(){
            if(parent==null||parent.parent==null){
                return null;
            }
            if(parent.isLeftChild()){
                return parent.parent.right;
            }
            else{
                return parent.parent.left;
            }
        }
        Node sibling(){
            if(parent==null){
                return null;
            }
            if(this.isLeftChild()){
                return parent.right;
            }
            return parent.left;
        }
        Node(int key,Object val){
            this.key = key;
            this.val = val;
        }
    }

    private boolean isRed(Node root){
        return root!=null&&root.color==Color.Red;
    }
    private boolean isBlack(Node root){
        return root==null||root.color==Color.Black;
    }
    private void rightRotate(Node root){
        Node parent = root.parent;
        Node head = root.left;
        root.left = head.right;
       if(head.right!=null){
           head.right.parent = root;
       }
       head.right = root;
       head.parent = root.parent;
       root.parent = head;
       if(parent!=null){
           if(parent.left==root){
               parent.left = head;
           }
           else{
               parent.right = head;
           }
       }
       else{
           this.root = head;
       }
    }
    private void leftRotate(Node root){
        Node parent = root.parent;
        Node head = root.right;
        root.right = head.left;
        if(head.left!=null){
            head.left.parent = root;
        }
        head.left = root;
        head.parent = parent;
        root.parent = head;
        if(parent!=null){
            if(parent.left == root){
                parent.left = head;
            }
            else{
                parent.right = head;
            }
        }
        else{
            this.root = head;
        }

    }
    public void put(int key,Object val){
        Node p = this.root;
        if(this.root==null){
            this.root = new Node(key,val);
            return;
        }
        Node parent = null;
        while(p!=null){
            parent = p;
            if(p.key==key){
                p.val = val;
                return;
            }
            else if(p.key>key){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }
        Node newNode = new Node(key,val);
        newNode.parent = parent;
        if(parent.key>key){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }
        fix(newNode);
    }
    private void fix(Node root){
        if(this.root==root){
            root.color = Color.Black;
            return;
        }
        if(isBlack(root.parent)){
            return;
        }
        Node parent = root.parent;
        Node uncle = root.uncle();
        Node grandparent = parent.parent;
        if(isRed(uncle)){
            parent.color = Color.Black;
            uncle.color = Color.Black;
            grandparent.color = Color.Red;
            fix(grandparent);
            return;
        }
        if(parent.isLeftChild()&&root.isLeftChild()){
            parent.color = Color.Black;
            grandparent.color = Color.Red;
            rightRotate(grandparent);
        }
        else if(parent.isLeftChild()&&!root.isLeftChild()){
            leftRotate(parent);
            root.color = Color.Black;
            grandparent.color = Color.Red;
            rightRotate(grandparent);
        }
        else if(parent.parent!=null&&!parent.isLeftChild()&&!root.isLeftChild()){
            parent.color = Color.Black;
            grandparent.color = Color.Red;
            leftRotate(grandparent);
        }
        else{
            if(parent.parent==null){
                return;
            }
            rightRotate(parent);
            root.color = Color.Black;
            grandparent.color = Color.Red;
            leftRotate(grandparent);
        }
    }
    public Node find(int key){
        Node p = this.root;
        while(p!=null){
            if(p.key>key){
                p = p.left;
            }
            else if(p.key<key){
                p = p.right;
            }
            else{
                return p;
            }
        }
        return p;
    }
    public Node findReplace(Node root){
        if(root.left==null&&root.right==null){
            return null;
        }
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
        Node p = root.right;
        while(p.left!=null){
            p = p.left;
        }
        return p;
    }
    public void remove(int key){
        Node delete = find(key);
        if(delete==null){
            return;
        }
        doRemove(delete);
    }
    private void doRemove(Node root){

    }
    public void print(){
        Node root = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                Node t = stack.pop();
                System.out.print(t.val+" ");
                root = t.right;
            }
        }

    }

}
