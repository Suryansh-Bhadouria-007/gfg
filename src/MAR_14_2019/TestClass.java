package MAR_14_2019;

/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String split[] = line.split(" ");
        Integer n = Integer.parseInt(split[0]);
        Integer m = Integer.parseInt(split[1]);
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    graph[i][j] = Integer.MAX_VALUE;
                else if (i == j)
                    graph[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]+"\t\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            line = br.readLine();
            split = line.split(" ");
            int k = Integer.parseInt(split[0]);
            int t = Integer.parseInt(split[1]);
            line = br.readLine();
            String vertices[] = line.split(" ");
            line = br.readLine();
            String weights[] = line.split(" ");
            for (int index = 0; index < vertices.length - 1; index += 1) {
                int start = Integer.parseInt(vertices[index]);
                int end = Integer.parseInt(vertices[index + 1]);
                graph[start - 1][end - 1] = Integer.parseInt(weights[index]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]+"\t\t\t");
            }
            System.out.println();
        }
        line = br.readLine();
        String endpoints[] = line.split(" ");
        int start = Integer.parseInt(endpoints[0]);
        int end = Integer.parseInt(endpoints[1]);
        System.out.println(floydWarshall(graph, n, start - 1, end - 1));

    }

    static int floydWarshall(int graph[][], int V, int start, int end) {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist[start][end];
    }
}
