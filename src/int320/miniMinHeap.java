/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mosza16
 */
public class miniMinHeap<T extends Comparable> {

    List<T> items = new ArrayList<T>();

    public miniMinHeap() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    private void shilfup(int index) {
        int parent = (index - 1) / 2;
        if (parent > 0) {
            if (items.get(index).compareTo(items.get(parent)) < 0) {
                swap(index, parent);
                shilfup(parent);
            }
        } else if (parent == 0) {
            if (items.get(index).compareTo(items.get(parent)) < 0) {
                swap(index, parent);
                
            }
        }
    }

    public void shilfup() {
        shilfup(items.size() - 1);
    }

    private void shilfDown(int parent, final int sizeList) {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        if (leftChild < sizeList && rightChild < sizeList) {
            int check = items.get(leftChild).compareTo(items.get(rightChild));
            if (check < 0) {
                boolean lessThanParent = items.get(leftChild).compareTo(items.get(parent)) < 0;
                if (lessThanParent) {
                    swap(parent, leftChild);
                    shilfDown(leftChild, sizeList);
                }
            } else if (check > 0) {
                boolean lessThanParent = items.get(rightChild).compareTo(items.get(parent)) < 0;
                if (lessThanParent) {
                    swap(parent, rightChild);
                    shilfDown(rightChild, sizeList);
                }
            }
        } else if (leftChild < sizeList) {

            boolean lessThanParent = items.get(leftChild).compareTo(items.get(parent)) < 0;
            if (lessThanParent) {
                swap(parent, leftChild);
                shilfDown(leftChild, sizeList);
            }

        } else if (rightChild < sizeList) {

            boolean lessThanParent = items.get(rightChild).compareTo(items.get(parent)) < 0;
            if (lessThanParent) {
                swap(parent, rightChild);
                shilfDown(rightChild, sizeList);
            }

        }
    }

    public boolean add(T t) {
        boolean a = items.add(t);
        shilfup();
        return a;
    }

    public T dequeqe() {
        T t = items.remove(0);
        shilfDown(0, items.size());
        return t;
    }

    private void inOrder(int index) {
        if (index < items.size()) {
            inOrder(index * 2 + 1);
            System.out.print(" " + items.get(index));
            inOrder(index * 2 + 2);
        }
    }
    public List<T> dequeqeAll(){
        List<T> t = new ArrayList<>();
        while(!items.isEmpty()){
            t.add(dequeqe());
        }
        return t;
    }

    public void inOrder() {
        inOrder(0);
    }

    public void breathFirst() {
        for (T t : items) {
            System.out.print(" " + t);
        }
    }

    private void swap(int index1, int index2) {
        T tmp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, tmp);

    }

    public static void main(String[] args) {
        miniMinHeap<Integer> heap = new miniMinHeap<Integer>();
        heap.add(50);
        heap.add(1);
        heap.add(50);
        heap.add(50);
        heap.add(5);
        heap.add(50);
        heap.add(-50);
        heap.breathFirst();
        System.out.println("");
        for(Integer i:heap.dequeqeAll()){
            System.out.print(i+" ");
        }
        Set<String> m = new HashSet<String>();
        
    }
}
