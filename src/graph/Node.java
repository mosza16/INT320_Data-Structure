/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 *
 * @author mosza16
 */
public class Node<T> {

    private T vertex;
    private List<Edge<T>> edges;
    private Map<Node, Path> paths = new HashMap<Node, Path>();

    @Override
    public String toString() {
        return "" + vertex;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }
    
    public  int incident(){
        int i = 0;
        for(Edge e : getEdges()){
            if(e.getFromNode().equals(this)){
                i++;
            }
        }
        return i;
    }
    public Node(T vertex) {
        this.vertex = vertex;
        edges = new ArrayList<>();
    }

    public T getVertex() {
        return vertex;
    }

    public boolean addEdge(Node<T> toNode, int weight) {
        if (hasEdge(toNode)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, toNode, weight);
        return edges.add(newEdge);
    }
    public boolean addUndirect(Node<T> toNode, int weight){
        if (hasEdge(toNode)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, toNode, weight);
        toNode.addEdge(this, weight);
        return edges.add(newEdge);
    }

    private Optional<Edge<T>> findEdge(Node<T> node) {
        return edges.stream().filter(e -> e.isBetween(this, node)).findFirst();
    }

    public boolean hasEdge(Node<T> node) {
        return findEdge(node).isPresent();
    }
    PriorityQueue<Edge> queue = new PriorityQueue<>();

    public void buildShortestPath(List<Edge<T>> edges, Node source) {

        while (!queue.isEmpty()) {
            Edge e = queue.remove();
            Node n = e.getToNode();
            int costs = e.getCost();
            if (n != null && !paths.containsKey(n)) {
                addQ(n.edges, costs);
                paths.put(n, new Path(true, costs, e.getFromNode()));

            } else if (paths.containsKey(n)) {
                if (!paths.get(n).isShortest) {
                    addQ(n.edges, costs);
                    paths.replace(n, new Path(true, costs, e.getFromNode()));
                }
            }
        }
        queue.clear();

    }

    public void prim() {
        queue.addAll(this.edges);
        while(!queue.isEmpty()) {
            Edge e = queue.remove();
            Node<String> n = e.getToNode();
            if (!paths.containsKey(n) && n != null ) {
                queue.addAll(n.edges);
                paths.put(n, new Path(true, e.getCost(), e.getFromNode()));
            } else if (paths.containsKey(n)) {
                if (!paths.get(n).isShortest ) {
                    queue.addAll(n.edges);
                    paths.put(n, new Path(true, e.getCost(), e.getFromNode()));
                }
            }
        }
        queue.clear();

    }
    public void kruskalPath(List<Edge> allEdge){
       queue.addAll(allEdge);
       while(!queue.isEmpty()){
           Edge e = queue.remove();
           Node<String> n = e.getToNode();
            if (!paths.containsKey(n) && n != null ) {
                paths.put(n, new Path(true, e.getCost(), e.getFromNode()));
            } else if (paths.containsKey(n)) {
                if (!paths.get(n).isShortest ) {
                    paths.put(n, new Path(true, e.getCost(), e.getFromNode()));
                }
            }
       }
    }

    public void shortestPath() {
        paths.put(this, new Path(true, 0, this));
        for (Edge e : edges) {
            System.out.println("" + e);
            queue.add(e);
        }
        buildShortestPath(edges, this);
    }

    public void addQ(List<Edge> edges, int cost) {
        for (Edge e : edges) {
            Edge e2 = new Edge(e.getFromNode(), e.getToNode(), e.getCost());
            e2.setCost(e.getCost() + cost);
            queue.add(e2);
        }
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        A.addUndirect(B, 4);
        A.addEdge(C, 2);
        
 
        Graph.breathFirst(A);
       // A.shortestPath();
        //A.kruskalPath(es);
     

    }

}
