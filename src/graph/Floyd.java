/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author mosza16
 */
public class Floyd {

    public static void main(String[] args) {
        int graphs[][] = new int[3][3];
        //intitial  [row][column]
        graphs[0][1] = 3;
        graphs[0][2] = 10;
        graphs[1][2] = 1;
        graphs[2][0] = 1;
        System.out.println("intitial");
        System.out.println("  A B C");
        for (int i = 0; i < graphs.length; i++) {
            System.out.print(Character.toChars(i + 65));
            for (int j = 0; j < graphs.length; j++) {
                System.out.print(" " + graphs[i][j]);
            }
            System.out.println("");
        }
        System.out.println("------------------------------");
        System.out.println("after use floyd's");
        for (int i = 0; i < graphs.length; i++) {
            for (int j = 0; j < graphs.length; j++) {
                if (graphs[i][j] > 0) {
                    int count = graphs[i][j];
                    int k = 0;
                    while (k < graphs.length) {
                        if (graphs[j][k] != 0) {
                            if (graphs[j][k] + count < graphs[i][k] || graphs[i][k] == 0) {
                                graphs[i][k] = graphs[j][k] + count;
                            }
                        }
                        k++;
                    }
                }
            }
        }
        System.out.println("  A B C");
        for (int i = 0; i < graphs.length; i++) {
            System.out.print(Character.toChars(i + 65));
            for (int j = 0; j < graphs.length; j++) {
                System.out.print(" " + graphs[i][j]);
            }
            System.out.println("");
        }
    }
}
