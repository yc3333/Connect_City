package Main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class Prim_Matrix {

    public void Prim_Matrix(double G[][], int V, String output) throws IOException {

        FileWriter myWriter = new FileWriter(output);

        int infinity = 9999999;
        double max = 0;

        int num_edges; // number of edge

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

            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    for (int j = 0; j < V; j++) {
                        // not visited and there is an edge
                        if (!visited[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            String str = String.format("%d - %d : %f\n", x ,y, min);
            myWriter.write(str);
            System.out.println(x + " - " + y + " :  " + G[x][y]);
            max += G[x][y];
            visited[y] = true;
            visited[x] = true;
            num_edges++;
        }
        System.out.println("Number of edges: " + num_edges);
        System.out.println("Total weight: " + max);
    }
}