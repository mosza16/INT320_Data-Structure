/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mosza16
 * @param <T>
 */
public class Maxheap<T extends Comparable<T>> {

    List<T> items = new ArrayList<>();

    public void shiftup() {
        int indexOfChild = items.size() - 1;
        while (true) {
            int indexOfparent = (indexOfChild - 1) / 2;
            if (items.get(indexOfChild).compareTo(items.get(indexOfparent)) > 0) {
                //swap
                swap(indexOfparent, indexOfChild);
            } else {
                break;
            }
            indexOfChild = indexOfparent;
        }
    }

    public void add(T t) {
        items.add(t);
        shiftup();
    }

    public void addFirst(T t) {
        items.add(0, t);
        shiftDown();
    }

    private void swap(int index1, int index2) {
        T x = items.get(index1);
        // System.out.println(items.get(index1) + " To " + items.get(index2));
        items.set(index1, items.get(index2));
        items.set(index2, x);
    }

    public void remove() {
        items.remove(0);
        shiftDown();
    }

    public T dequequ() {
        T t = items.remove(0);
        shiftDown();
        return t;
    }

    public void shiftDown() {
        int indexOfChildLeft = (2 * 0) + 1;
        int indexOfChildRight = (2 * 0) + 2;
        int indexOfParent = 0;
        while (true) {
            if (IndexIsEmply(indexOfChildRight) && IndexIsEmply(indexOfChildLeft)) {
                break;
            } else {
                if (IndexIsEmply(indexOfChildRight) && !IndexIsEmply(indexOfChildLeft)) {
                    if (items.get(indexOfParent).compareTo(items.get(indexOfChildLeft)) < 0) {
                        swap(indexOfChildLeft, indexOfParent);
                    }
                    break;
                } else if (!IndexIsEmply(indexOfChildRight) && IndexIsEmply(indexOfChildLeft)) {
                    if (items.get(indexOfParent).compareTo(items.get(indexOfChildRight)) < 0) {
                        swap(indexOfChildRight, indexOfParent);
                    }
                    break;
                } else if (!IndexIsEmply(indexOfChildRight) && !IndexIsEmply(indexOfChildLeft)) {
                    T l = items.get(indexOfChildLeft);
                    T r = items.get(indexOfChildRight);
                    if (l.compareTo(r) > 0) {
                        if (items.get(indexOfParent).compareTo(items.get(indexOfChildLeft)) < 0) {
                            swap(indexOfChildLeft, indexOfParent);
                        } else {
                            break;
                        }
                        indexOfParent = indexOfChildLeft;
                    } else if (l.compareTo(r) < 0) {
                        if (items.get(indexOfParent).compareTo(items.get(indexOfChildRight)) < 0) {
                            swap(indexOfChildRight, indexOfParent);
                        } else {
                            break;
                        }
                        indexOfParent = indexOfChildRight;
                    } else {
                        if (items.get(indexOfParent).compareTo(items.get(indexOfChildLeft)) < 0) {
                            swap(indexOfChildLeft, indexOfParent);
                        } else {
                            break;
                        }
                        indexOfParent = indexOfChildLeft;
                    }
                }
            }
            indexOfChildLeft = (2 * indexOfParent) + 1;
            indexOfChildRight = (2 * indexOfParent) + 2;

        }
    }

    private boolean IndexIsEmply(int index) {
        try {
            T t = items.get(index);
        } catch (IndexOutOfBoundsException ex) {
            return true;
        }
        return false;
    }

    private void preOrder(int index) {
        if (IndexIsEmply(index)) {
        } else {
            System.out.print(items.get(index) + " | ");
            if (!IndexIsEmply(index * 2 + 1)) {
                preOrder(index * 2 + 1);
            }
            if (!IndexIsEmply(index * 2 + 2)) {;
                preOrder(index * 2 + 2);
            }
        }
    }

    private void inOrder(int index) {
        if (IndexIsEmply(index)) {
        } else {

            if (!IndexIsEmply(index * 2 + 1)) {
                inOrder(index * 2 + 1);
            }
            System.out.print(items.get(index) + " | ");
            if (!IndexIsEmply(index * 2 + 2)) {;
                inOrder(index * 2 + 2);
            }
        }
    }

    private void postOrder(int index) {
        if (IndexIsEmply(index)) {
        } else {
            if (!IndexIsEmply(index * 2 + 1)) {
                postOrder(index * 2 + 1);
            }
            if (!IndexIsEmply(index * 2 + 2)) {;
                postOrder(index * 2 + 2);
            }
            System.out.print(items.get(index) + " | ");
        }
    }

    public void preOrder() {
        preOrder(0);
    }

    public void inOrder() {
        inOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }

    public T indexOfSecondMin() {
        Stack<T> s1 = new Stack();
        Stack<T> s2 = new Stack();
        for (int i = 0; i < items.size(); i++) {
            if (s1.isEmpty()) {
                s1.push(items.get(i));
            } else {
                if (items.get(i).compareTo(s1.peek()) < 0) {
                    if (s2.isEmpty()) {
                        s2.push(s1.pop());
                    } else {
                        s2.clear();
                        s2.push(s1.pop());
                    }
                    s1.push(items.get(i));
                } else {
                    if (s2.isEmpty()) {
                        s2.push(items.get(i));
                    } else {
                        if (s2.peek().compareTo(items.get(i)) > 0) {
                            s2.clear();
                            s2.push(items.get(i));
                        }
                    }
                }
            }
        }
        return s2.pop();
    }

    public T indexOfSecondMax() {
        Stack<T> s1 = new Stack();
        Stack<T> s2 = new Stack();
        for (int i = 0; i < items.size(); i++) {
            if (s1.isEmpty()) {
                s1.push(items.get(i));
            } else {
                if (items.get(i).compareTo(s1.peek()) > 0) {
                    if (s2.isEmpty()) {
                        s2.push(s1.pop());
                    } else {
                        s2.clear();
                        s2.push(s1.pop());
                    }
                    s1.push(items.get(i));
                } else {
                    if (s2.isEmpty()) {
                        s2.push(items.get(i));
                    } else {
                        if (s2.peek().compareTo(items.get(i)) > 0) {
                            s2.clear();
                            s2.push(items.get(i));
                        }
                    }
                }
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        Maxheap<Integer> heap1 = new Maxheap<>();

        heap1.add(5);
        heap1.add(4);
        heap1.add(3);
        heap1.add(8);
        heap1.add(10000);
        heap1.add(123);
        System.out.println(heap1.items.size());
        List order = new ArrayList<>();
        int size = heap1.items.size();
        long time = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Integer a = heap1.dequequ();
            System.out.println("a is  : " + a);
            order.add(a);
        }
        System.out.println("take Time : " + (System.currentTimeMillis() - time));
        for (Object i : order) {
            System.out.println(i);
        }
    }
}
