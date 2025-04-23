import java.util.*;
public class P25_BellmanFord {
    public static void main(String[] args) {
        try {
            int V = 3, src = 2;
            int[][] edges = new int[][]{{0,1,5}, {1,0,3}, {1,2,-1}, {2,0,1}};

            int[] distance = new int[V];
            Arrays.fill(distance, (int)1e9);
            distance[src] = 0;
            // Relax edges for V-1 iterations
            for (int i=0;i<V-1;i++) {
                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    if (distance[u] != (int)1e9 && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }

            // Nth relaxation for detecting negative cycle
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (distance[u] != (int)1e9 && distance[u] + wt < distance[v]) {
                    System.out.println(-1);
                    return;
                }
            }
            for (int i=0;i<distance.length;i++)
                System.out.print(distance[i] + " ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
