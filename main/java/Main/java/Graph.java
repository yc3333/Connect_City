/* *****************************************
 * CSCI311
 *
 * Name: Charlie Taylor, Mohamed Bakr, Sara Micciulli, Yuhan Chen
 * Date: 12/1/2021
 * Time: 9:57 PM
 *
 * Project: project2
 * Package: Main.java
 * Class: Graph
 *
 * Description: Graph calss
 *
 * ****************************************
 */
package Main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public HashMap<Node, List<Edge>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdge(Node s, Node d, double l) {

        Edge s_d = new Edge(s, d, l);
        Edge d_s = new Edge(d, s, l);

        if (!adjacencyMap.keySet().contains(s)) {
            adjacencyMap.put(s, null);
        }

        if (!adjacencyMap.keySet().contains(d)) {
            adjacencyMap.put(d, null);
        }

        List<Edge> sEdge = adjacencyMap.get(s);
        List<Edge> dEdge = adjacencyMap.get(d);

        //add edge s_d to s's node list
        if (sEdge == null){
            sEdge = new LinkedList<>();
        }
        sEdge.add(s_d);
        adjacencyMap.put(s, sEdge);

        //add edge d_s to d's node list
        if (dEdge == null){
            dEdge = new LinkedList<>();
        }
        dEdge.add(d_s);
        adjacencyMap.put(d, dEdge);

    }


    public boolean hasEdge(Node s, Node d) {
        List<Edge> edges = adjacencyMap.get(s);
        for (Edge edge : edges) {
            Node n = edge.getEndNode();
            if (n.id == d.id) return true;
        }
        return false;
    }

    public Node hasNode(int id) {
        for (Node key : adjacencyMap.keySet()) {
            if (key.getId() == id) {
                return key;
            }
        }
        return null;
    }

    public void printGraph(){
        for(Node n: adjacencyMap.keySet()){
            String Nodestr = String.valueOf(n.getId());
            String edgestr = "";
            List<Edge> listEdge = adjacencyMap.get(n);
            for (Edge e: listEdge) {
                edgestr += e.retEdgeStr();
            }
            System.out.println(Nodestr + " >>> " + edgestr);
        }
    }

    public double[][] convertToAdjMatrix(){
        int vertices = adjacencyMap.size();
        double[][] adjMatrix = new double[vertices][vertices];
        for(int i=0; i<adjMatrix.length; i++){
            for(int j =0; j<adjMatrix.length; j++){
                adjMatrix[i][j] =0;
            }
        }
        for(Node n: adjacencyMap.keySet()){
            List<Edge> listEdge = adjacencyMap.get(n);
            for (Edge e: listEdge) {
                int vert1 = e.getStartNode().getId();
                int vert2 = e.getEndNode().getId();
                double len = e.getLength();
                adjMatrix[vert1][vert2] = len;
                adjMatrix[vert2][vert1] = len;
            }
        }
        return adjMatrix;
    }

    public int nodeCount() {
        int count = 0;
        for(Node n: adjacencyMap.keySet()){
            count++;
        }
        return count;
    }
}