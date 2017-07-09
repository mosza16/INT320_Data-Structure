/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.Arrays;

/**
 *
 * @author mosza16
 */
public class quickSort {
final static int CUTOFF=3;
    public static void quickSort(Comparable[] array, int right, int left, int pivot, int count) {
        if (count == array.length - CUTOFF) {

        } else {
            if (pivot == right && pivot == left && right == left) {//When pivot==rightIndex==leftIndex
              //  System.out.println(Arrays.toString(array));
             //   System.out.print(" ");
            /*    for (int i = 0; i < pivot; i++) {
                    System.out.print("   ");
                }
                System.out.print("^\n");*/
                int mid = array.length / 2;
                if (pivot < mid) {

                 //   System.out.println("quick right pivot is : " + pivot);
                  //  System.out.println("------------------------------");
                    quickSort(array, array.length - 1, pivot + 1, pivot + 1, ++count);
                } else {
                 //   System.out.println("quick left pivot is : " + pivot);
                 //   System.out.println("------------------------------");
                    quickSort(array, pivot, 0, 0, ++count);
                }
               // quickSort(array, array.length-1, 0, 0, ++count);

            } else {
                if (pivot == right && right > left) {
                    if (array[pivot].compareTo(array[left]) < 0) {//less to more
                        swap(array, left, pivot);
                        quickSort(array, right, left, left, count);
                    } else {
                        quickSort(array, right, ++left, pivot, count);
                    }
                }
                if (pivot == left && right > left) {
                    if (array[pivot].compareTo(array[right]) > 0) {//less to more 
                        swap(array, right, pivot);
                        quickSort(array, right, left, right, count);
                    } else {
                        quickSort(array, --right, left, pivot, count);
                    }
                }
            }
        }
    }

    public static void quickSort(Comparable[] a) {
        quickSort(a, a.length - 1, 0, a.length - 1, 0);
    }

    private static void swap(Comparable[] a, int b, int c) {
        Comparable tmp = a[b];
        a[b] = a[c];
        a[c] = tmp;
    }

    public static void main(String[] args) {
        Integer[] i = {1, 1, 7, 8, 5, 2, 3, 4, 9};
        long a = System.currentTimeMillis();
        quickSort(i);
       // sort.insertionSort.insertionSort(i);
        System.out.println(Arrays.toString(i));
        System.out.println(System.currentTimeMillis() - a);
    }
}
