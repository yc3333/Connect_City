/* *****************************************
 * CSCI311
 *
 * Name: Charlie Taylor, Mohamed Bakr, Sara Micciulli, Yuhan Chen
 * Date: 12/1/2021
 * Time: 11:45 PM
 *
 * Project: project2
 * Package: Main.java
 * Class: main
 *
 * Description:
 *
 * ****************************************
 */
package Main.java;

import java.io.*;
import java.util.HashMap;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class main {
    public static Graph readFile(FileInputStream fs) throws IOException {
        Graph rtn = new Graph();
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        String line;
        while ((line = br.readLine())!=null) {
            String[] token = line.split(" ");
            int sId = parseInt(token[1]);
            int dId = parseInt(token[2]);
            Node startNode;
            Node endNode;
            if ((startNode = rtn.hasNode(sId)) == null) {
                startNode = new Node(sId);
            }
            if ((endNode = rtn.hasNode(dId)) == null) {
                endNode = new Node(dId);
            }
            double length = parseDouble(token[3]);
            rtn.addEdge(startNode, endNode, length);
        }
        return rtn;
    }


    public static void main(String[] args) throws IOException {
        //System.out.println("Prim's Algorithm using Adjacency Matrix");
        System.out.println("Prim's Algorithm using Adjacency List");
        FileInputStream fstream = new FileInputStream(args[0]);
        Graph g = readFile(fstream);
        //g.printGraph();

        //FileWriter myWriter = new FileWriter("test.txt");
        //double[][] adjMatrix = g.convertToAdjMatrix(); // comment for list
        /*
        for(int i=0; i<adjMatrix.length; i++){
            for(int j =0; j<adjMatrix.length; j++){
                String str = String.format("%.2f   ", adjMatrix[i][j]);
                myWriter.write(str);
            }
            myWriter.write("\n");
        }
        */
        fstream.close();
        System.out.println("Done reading.");
        int nodeCount = g.nodeCount();
        //System.out.println("Node Count: " + g.nodeCount());
        Prim_List plist = new Prim_List();
        plist.Prim_List(g, nodeCount, args[1]);
        //Prim_Matrix pmatrix = new Prim_Matrix();
        //pmatrix.Prim_Matrix(adjMatrix, nodeCount, args[1]);

    }
}
