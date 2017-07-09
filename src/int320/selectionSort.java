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
public class selectionSort {
    public static void selectionSort(Comparable[] array){
        int indexOfmin = 0;
        for(int i = 0;i<array.length;i++){
            indexOfmin = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j].compareTo(array[indexOfmin])<0){
                    indexOfmin = j;
                }
            }  
            Comparable tmp = array[i]; 
            array[i] = array[indexOfmin];
            array[indexOfmin] = tmp;
        }
        
    }
    public static void main(String[] args) {
        Integer[] a = {561,74,99,4,2,6,87};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
