/* *****************************************
 * CSCI311
 *
 * Name: Charlie Taylor, Mohamed Bakr, Sara Micciulli, Yuhan Chen
 * Date: 12/1/2021
 * Time: 9:57 PM
 *
 * Project: project2
 * Package: Main.java
 * Class: Edge
 *
 * Description: Edge class
 *
 * ****************************************
 */
package Main.java;

public class Edge {
    Node startNode;
    Node endNode;
    double length;
    public Edge(Node startNode, Node endNode, double length) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.length = length;
    }

    public Node getStartNode() {
        return startNode;
    }

    public double getLength() {
        return length;
    }

    public Node getEndNode() {
        return endNode;
    }

    public String retEdgeStr(){
        String edgeStr = "Start: " + String.valueOf((startNode.getId()))+ " End: " + String.valueOf(endNode.getId()) + " Length: " + String.valueOf(length);
        return edgeStr;
    }
}