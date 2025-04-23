import java.util.*;
public class L18_ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        try {
            int V = 9;
            int[][] edges = new int[][]{{0,1}, {0,3}, {1,0}, {1,2}, {2,1}, {2,6}, {3,0}, {3,4}, {4,3}, {4,5}, {5,4}, {5,6}, {6,2}, {6,5}, {6,7}, {6,8}, {7,6}, {7,8}, {8,7}, {8,6}};
            int src = 0;

            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<V;i++) 
                adj.add(new ArrayList<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            int[] distance = new int[V];
            Arrays.fill(distance, (int)1e9);
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            distance[src] = 0;

            while (!q.isEmpty()) {
                int curr_node = q.poll();
                for (int x : adj.get(curr_node)) {
                    if (distance[curr_node] + 1 < distance[x]) {
                        distance[x] = distance[curr_node] + 1;
                        q.add(x);
                    }
                }
            }
            for (int i=0;i<V;i++) {
                if (distance[i] == (int)1e9)
                    System.out.print(-1 + " ");
                System.out.print(distance[i] + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
