/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mosza16
 */
public class quickSortByAJ {
    final static int CUTOFF = 2;
    private static int selectPivot(Comparable[] a,int left,int right){
        int mid = (left+right)/2;
        if(a[mid].compareTo(a[left])<0){
            swap(a, left, mid);
        }
        if(a[left].compareTo(a[right])>0){
            swap(a, right, left);
        }
        if(a[mid].compareTo(a[right])>0){
            swap(a, right, mid);
        }
        return mid;
    }
    private static void quickSort(Comparable[] a,int left,int right){
        if((right-left)>=CUTOFF){
        int mid = selectPivot(a, left, right);
        swap(a, mid, right);
        int i = left;
        int j = right-1;
         while(true){
             while(i<=j&&a[i].compareTo(a[right])>=0)i++;//a[right] is pivot data//Max to min
             while(i<=j&&a[j].compareTo(a[right])<0)j--;//Max to min
             if(j<=i) break;
             swap(a, i++, j--);
         }
         if(a[i].compareTo(a[right])<0)//Max to min
             swap(a, i, right);
         if(left<i)quickSort(a, left, i-1);
         if(right>i)quickSort(a, i+1, right);
        }
    }
    private static void quickSort(Comparable[] a){
        if(a.length-1>0){
            quickSort(a, 0, a.length-1);
        }
    }
   private static void swap(Comparable[] a, int b, int c) {
       if(c!=b){ 
       Comparable tmp = a[b];
        a[b] = a[c];
        a[c] = tmp;
       }
    }
    public static void main(String[] args) {
        Integer[] i = {1,9,5,5,100,6,8,65,4,89};
       
        
        quickSort(i);
        System.out.println(Arrays.toString(i));
    }
}
