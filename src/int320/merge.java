/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

/**
 *
 * @author mosza16
 */
public class merge {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5,5};
        int[] b = {1,11,10};
        int[] c = new int[a.length+b.length];   
       int countC=0;
        for (int i = 0; i < a.length; i++) {
            boolean add=true; 
             for(int x:c){
                if(x==a[i]){
                     add =false;
                    break; 
                }
            } 
             if(add)
            c[countC++]=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            boolean add=true; 
             for(int x:c){
                if(x==b[i]){
                     add =false;
                    break; 
                }
            } 
             if(add)
            c[countC++]=b[i];
        }
        for(int x:c){
            System.out.print(x==0?"":x+",");
        }
    }
}
