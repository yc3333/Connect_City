package Main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Prim_List {

    public void Prim_List(Graph G, int V, String output) throws IOException {

        FileWriter myWriter = new FileWriter(output);


        int infinity = 9999999;
        double max = 0;

        int num_edges; // number of edges

        // create an array to track visited vertices
        boolean[] visited = new boolean[V];

        // set visited false initially
        Arrays.fill(visited, false);

        // set number of edges to 0
        num_edges = 0;

        // choose 0th vertex and make it true
        visited[0] = true;

        System.out.println("Edge : Weight");

        while (num_edges < V - 1) {
            double min = infinity;
            int x = 0; // row
            int y = 0; // col
            Node n;
            Node m;

            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    n = G.hasNode(i);
                    List<Edge> listEdge = G.adjacencyMap.get(n);
                    for (Edge edge : listEdge) {
                        m = edge.getEndNode();
                        if (!visited[m.getId()]) {
                            if (min > edge.length) {
                                min = edge.length;
                                x = n.getId();
                                y = m.getId();
                            }
                        }
                    }
                }
            }
            String str = String.format("%d - %d : %f\n", x ,y, min);
            myWriter.write(str);
            System.out.println(x + " - " + y + " :  " + min);
            visited[y] = true;
            visited[x] = true;
            num_edges++;
            max += min;
        }
        System.out.println("Number of edges: " + num_edges);
        System.out.println("Total weight: " + max);
    }
}