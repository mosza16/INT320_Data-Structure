/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL_Tree;

/**
 *
 * @author mosza16
 */
public class AVL2<T, K extends Comparable> {

    Node root;
    int nodesSize;

    private static Node rotateRight(Node n) {
        Node childleft = null;
        if (n == null) {
            return null;
        } else {
            childleft = n.left;
            n.left = childleft.right;
            childleft.right = n;
        }
        return childleft;
    }

    private static Node rotateLeft(Node n) {
        Node childRight = null;
        if (n == null) {
            return null;
        } else {
            childRight = n.right;
            n.right = childRight.left;
            childRight.left = n;
        }
        return childRight;
    }

    private static Node DoubleRotateLR(Node n) {
        if (n == null) {
            return null;
        } else {
            n.left = rotateLeft(n.left);

            return rotateRight(n);
        }
    }

    private static Node DoubleRotateRL(Node n) {
        if (n == null) {
            return null;
        } else {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }
    }
    private static int getHeight(Node n){
        if(n==null){
            return 0;
        }else{
            return Math.max(getHeight(n.left),getHeight(n.right))+1;
        }
    }

    public Node addNode(Node n, Node root) {
            if (root == null) {
                return n;
            } else {
                if (n.key.compareTo(root.key) < 0) {
                    root.left = addNode(n, root.left);
                    if(getHeight(root.left)-getHeight(root.right)>=2){
                        return rotateRight(root);
                         
                    }else if(getHeight(root.left)-getHeight(root.right)<=-2){
                         return DoubleRotateRL(root);
                    }
                } else if (n.key.compareTo(root.key) > 0) {
                    root.right = addNode(n, root.right);
                     if(getHeight(root.left)-getHeight(root.right)>=2){
                        return DoubleRotateLR(root);
                         
                    }else if(getHeight(root.left)-getHeight(root.right)<=-2){
                         return rotateLeft(root);
                    }      
                }else{
                    //duplicateKEY     
                }
                return root;
            }
        
    }
    public void add(Node n){
        if(this.root==null){
            this.root = n;
        }else{
           root= addNode(n, root);
        }
    }

    public static void main(String[] args) {
        AVL2 a = new AVL2();
        a.add(new Node(10, 10));
        a.add(new Node(5,5));
        a.add(new Node(16,16));
        a.add(new Node(17,17));
        a.add(new Node(18,18));
        a.add(new Node(8,8));
        a.add(new Node(7,7));
        inOrder(a.root);
      
    }

    public static void inOrder(Node n) {
        if (n == null) {

        } else {
            inOrder(n.left);
            System.out.print(n.key + "|");
            inOrder(n.right);
        }
    }

    public static void preOrder(Node n) {
        if (n == null) {

        } else {
            System.out.print(n.key + "|");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public static class Node<T, K extends Comparable> {

        Node left;
        Node right;
        T data;
        K key;

        public Node(T data, K key) {
            this.data = data;
            this.key = key;
        }

        public Node() {
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

    }
}
