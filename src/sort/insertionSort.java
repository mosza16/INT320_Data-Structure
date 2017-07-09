/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author mosza16
 */
public class insertionSort {

    public static void main(String[] args) {
        Integer[] a = { 1, 5, 1,5};
        insertionSort(a);
        System.out.println(Arrays.toString(a));

    }
    public static void insertionSort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            Comparable element = a[i];
            for (int j = i; j > 0 && a[j].compareTo(a[j - 1])<0 ; j--) {
                a[j] = a[j - 1];
                a[j - 1] = element;
                element = a[j - 1];
            }
      
        }
    }
}
