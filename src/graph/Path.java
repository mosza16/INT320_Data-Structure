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
public class Path {
    boolean isShortest;
    int cost;
    graph.Node source;

    public Path(boolean isShortest, int cost, Node source) {
        this.isShortest = isShortest;
        this.cost = cost;
        this.source = source;
    }

    public boolean isIsShortest() {
        return isShortest;
    }

    public void setIsShortest(boolean isShortest) {
        this.isShortest = isShortest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Path{" + "isShortest=" + isShortest + ", cost=" + cost + ", source=" + source +"\n";
    }
    
    
    
    
}
