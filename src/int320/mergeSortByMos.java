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
public class mergeSortByMos {
    private static void mergeSort(Comparable[] array,Comparable[]tmp,int leftIndex,int rightIndex){
        if(leftIndex<rightIndex){
            int mid = (leftIndex+rightIndex)/2;
               mergeSort(array, tmp, leftIndex, mid);
               mergeSort(array, tmp, mid+1,rightIndex);
               merge(array, tmp, leftIndex, mid+1, rightIndex);
        }
    }
    private static void merge(Comparable[] array,Comparable[]tmp,int leftIndex,int rightIndex, int rightEnd){
       final int LeftEnd = rightIndex-1;
       final int round = (rightEnd-leftIndex)+1;
       int indexOftemp = leftIndex;
       while(leftIndex<=LeftEnd&&rightIndex<=rightEnd)
           if(array[leftIndex].compareTo(array[rightIndex])<0)//less to more
               tmp[indexOftemp++] = array[leftIndex++];
           else
               tmp[indexOftemp++] = array[rightIndex++];
       while(leftIndex<=LeftEnd)
           tmp[indexOftemp++] = array[leftIndex++];
       while(rightIndex<=rightEnd)
           tmp[indexOftemp++] = array[rightIndex++];
       for(int i=0;i<round;i++,rightEnd--){
           array[rightEnd] = tmp[rightEnd];
       }
    }
    public static void mergeSort(Comparable[] array){
        Comparable[] tmp = new Comparable[array.length];
        mergeSort(array, tmp, 0, array.length-1);
    }
    public static void main(String[] args) {
        Comparable a[] = {5,9,7,1,0,6,8,41,126,65,489};
        long t = System.currentTimeMillis();
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
    
}
