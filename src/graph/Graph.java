/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author mosza16
 */
public class Graph {

    List<Node> n;
    List<Edge> e;

    public List<Node> getN() {
        return n;
    }

    public void setN(List<Node> n) {
        this.n = n;
    }

    public List<Edge> getE() {
        if (e == null) {
            e = new ArrayList<>();
        }
        for (Node node : n) {
            e.addAll(node.getEdges());
        }
        return e;
    }

    public void setE(List<Edge> e) {
        this.e = e;
    }
    static Set<Node> set = new HashSet<Node>();

    public static void depthFirst(Node n) {
        if (n == null) {
        } else {
            if (!set.contains(n)) {
                System.out.print(n.getVertex()+" ");
                set.add(n);
                if (!n.getEdges().isEmpty()) {
                    List<Edge> edges = n.getEdges();
                    for(Edge e : edges){
                        depthFirst(e.getToNode());
                    }
                }
            }
        }
    }
    static Queue<Node> queue = new LinkedList<Node>();
    static Set<Node> set2 = new HashSet<Node>();
    private static void breathFirst(){
            if(!queue.isEmpty()){
                Node node = queue.remove();                
                if(!set2.contains(node)){
                    System.out.print(node.getVertex()+" ");
                    set2.add(node);
                    List<Edge> e = node.getEdges();
                    if(!e.isEmpty()){
                        for(Edge es : e){
                            queue.add(es.getToNode());
                        }
                    }
                    
                }
                breathFirst();
            }
        
    }
    public static void breathFirst(Node n){
        if(n!=null){
            queue.add(n);
        }
        breathFirst();
    }
}
