package Tree;

public class AvlTree {
    public Node root;
    static class Node{
        int key;
        Node left;
        Node right;
        int height;
        Object val;
        public Node(int key,Object val){
            this.key = key;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.val = val;
        }
        public Node(){
            this.height = 1;
        }
    }
    private int getHeight(Node node){
        return node==null?0:node.height;
    }
    private void updateHeight(Node root){
        root.height = Math.max(getHeight(root.left),getHeight(root.right));
    }
    private int bf(Node root){
        return getHeight(root.left) - getHeight(root.right);
    }
    private Node rightRotate(Node root){
        Node head = root.left;
        root.left = head.right;
        head.right = root;
        updateHeight(root);
        updateHeight(head);
        return head;
    }
    private Node leftRotate(Node root){
        Node head = root.right;
        head.left = root;
        root.right = head.left;
        updateHeight(root);
        updateHeight(head);
        return head;
    }
    private Node leftRightRotate(Node root){
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }
    private Node rightLeftRotate(Node root){
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }
    private Node balance(Node root){
        if(root==null){
            return null;
        }
        if(bf(root)>1&&bf(root.left)>=0){
            return rightRotate(root);
        }
        else if(bf(root)>1&&bf(root.left)<0){
            return leftRightRotate(root);
        }
        else if(bf(root)<-1&&bf(root.right)<=0){
            return leftRotate(root);
        }
        else if(bf(root)<-1&&bf(root.right)>0){
            return rightLeftRotate(root);
        }
        return root;
    }
    public void put(int key,Object val){
            root = doput(root,key,val);
    }
    private Node doput(Node root,int key,Object val){
        if(root==null){
            return new Node(key,val);
        }
        if(root.key==key){
            root.val = val;
            return root;
        }
        if(root.key>key){
            root.left = doput(root.left,key,val);
        }
        else{
            root.right = doput(root.right,key,val);
        }
        bf(root);
        return balance(root);
    }
    public void printf(){
        print(root);
        System.out.println();
    }
    private void print(Node root){
        if(root==null){
            return;
        }
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public void remove(int key){
        doremove(root,key);
    }
    private Node doremove(Node root,int key){
        if(root==null){
            return null;
        }
       if(root.key>key){
           root.left = doremove(root.left,key);
       }
       else if(root.key<key){
           root.right = doremove(root.right,key);
       }
       else{
           if(root.right==null&&root.left==null){
               return null;
           }
           if(root.right==null){
               return root.left;
           }
           if(root.left==null){
               return root.right;
           }
           Node t = root.right;
           while(t.left!=null){
               t = t.left;
           }
           root.right = doremove(root.right,t.key);
           t.left = root.left;
           t.right = root.right;
           root = t;
       }
       updateHeight(root);
       return balance(root);
    }
}
