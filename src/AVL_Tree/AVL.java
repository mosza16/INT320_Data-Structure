/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL_Tree;

import static javafx.scene.input.KeyCode.K;
import javax.management.relation.Role;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author mosza16
 */
public class AVL<T, K> {

    Node root;

    public AVL() {

    }

    public Node addNodeByKey(Node t, Node newNode) {
        if (t == null) {
            t = newNode;
        } else {
            if (newNode.compareTo(t) > 0) {
                t.right = addNodeByKey(t.right, newNode);
                t = balance(t);
            } else if (newNode.compareTo(t) < 0) {
                t.left = addNodeByKey(t.left, newNode);     
                t = balance(t);
                
            }
        }
        return t;
    }

    public void add(Node n) {
        root = addNodeByKey(root, n);
    }

    private static boolean check(Node n) {
        return checkInt(n) >= 2 || checkInt(n) <= -2;
    }

    private static int checkInt(Node n) {
        int right = 0;
        int left = 0;
        if (n.right == null) {

        } else {
            right = getHeight(n.right);

        }
        if (n.left == null) {

        } else {
            left = getHeight(n.left);

        }

        return left - right;
    }

    private static Node rotateLeft(Node n) {
        Node childRight = n.right;
        childRight.parent = n.parent;
        n.parent = childRight;
        n.right = childRight.left;
        childRight.left = n;
        return childRight;

    }

    private static Node rotateRight(Node n) {
        Node childLeft = n.left;
        childLeft.parent = n.parent;
        n.parent = childLeft;
        n.left = childLeft.right;
        childLeft.right = n;

        return childLeft;

    }

    private static Node doubleRorateRL(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private static Node doubleRorateLR(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    static class Node<T, K> implements Comparable {

        Node left;
        Node right;
        Node parent;
        T data;
        K key;
        int height;

        public Node(Node left, Node right, Node parent, T data, K key) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.data = data;
            this.key = key;
        }

        public Node(T data, K key) {
            this.data = data;
            this.key = key;
        }

        public Node() {
        }

        @Override
        public int compareTo(Object o) {
            return key.hashCode() - ((Node) o).key.hashCode();
        }

    }

    public int sizeNodes(Node n) {
        if (n == null) {
            return 0;
        }
        int i = 0;
        i += sizeNodes(n.left);
        i += sizeNodes(n.right);
        return i + 1;
    }

    public static int getHeight(Node n) {
        if (n == null) {
            return 0;
        } else {
            return Math.max(getHeight(n.right), getHeight(n.left)) + 1;
        }
    }

    public static Node getMax(Node n) {
        if (n == null) {
            return n;
        } else {
            n.right = getMax(n.right);

        }
        if (n.right != null) {
            return n.right;
        } else {
            return n;
        }

    }

    public static Node getMin(Node n) {
        if (n == null) {
            return n;
        } else {
            n.left = getMin(n.left);
            if (n.left != null) {
                return n.left;
            } else {
                return n;
            }
        }
    }

    public Node<T, K> del(int n, Node root) {
        if (root != null) {
            int key = root.key.hashCode();
            if (n != key) {
                if (n > key) {
                    root.right = del(n, root.right);
                    return balance(root);
                    //

                } else if (n < key) {
                    root.left = del(n, root.left);
                    return balance(root);
                    //
                } else {
                    return null;
                }
            } else {//found
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    K maxkey = (K) (getMax(root.left).key);
                    root.key = maxkey;
                    root.left = del(maxkey.hashCode(), root.left);
                    return balance(root);
                    //
                }

            }
        } else {
            return null;
        }

    }

    public Node<T, K> balance(Node<T, K> n) {
        int x = checkInt(n);
        if (x >= 2) {
            // L L
            if (checkInt(n.left) > 0) {
                n = rotateRight(n);
            } else if (checkInt(n.left) < 0) {//LR
                n = doubleRorateLR(n);
            }

        } else if (x <= -2) {
            //RR
            if (checkInt(n.right) < 0) {
                n = rotateLeft(n);

            } else if (checkInt(n.right) > 0) {
                n = doubleRorateRL(n);
            }
        }
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        
        return n;
    }

    public static Node findNodeByKey(int k, Node root) {
        if (root != null) {
            int key = root.key.hashCode();
            if (k != key) {
                if (k > key) {
                    return findNodeByKey(k, root.right);
                } else if (k < key) {
                    return findNodeByKey(k, root.left);
                } else {
                    return null;
                }
            } else {
                return root;
            }
        } else {
            return null;
        }

    }

    public static void inOrder(Node n) {
        if (n == null) {

        } else {
            inOrder(n.left);
            System.out.print(n.data + " ");
            inOrder(n.right);
        }
    }

    public static void preOrder(Node n) {
        if (n == null) {

        } else {
            System.out.print(n.data + " ");
            preOrder(n.left);
            preOrder(n.right);

        }
    }

    public int sizeNodes() {
        return sizeNodes(root);
    }

    public static void main(String[] args) {
        AVL a = new AVL();
        a.add(new Node("50", 50));
        a.add(new Node("70", 70));
      
        inOrder(a.root);
        System.out.println(""+a.root.right.height);

    }
}
