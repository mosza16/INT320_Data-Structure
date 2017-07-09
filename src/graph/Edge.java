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
public class Edge<T> implements Comparable<Edge>{
    private Node<T> fromNode;
    private Node<T> toNode;
    private int cost;

    public Edge(Node<T> fromNode, Node<T> toNode, int cost) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = cost;
    }

    public Node<T> getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node<T> fromNode) {
        this.fromNode = fromNode;
    }

    public Node<T> getToNode() {
        return toNode;
    }

    public void setToNode(Node<T> toNode) {
        this.toNode = toNode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return   fromNode + "----->" + toNode ;
    }
    public boolean isBetween(Node<T> fromNode,Node<T> toNode){
        return this.fromNode==fromNode&&this.toNode==toNode;
    }

    @Override
    public int compareTo(Edge o) {
        return getCost()-o.getCost();
    }
    
}
