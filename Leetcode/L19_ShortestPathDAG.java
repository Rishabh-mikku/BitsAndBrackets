// Step 1- Perform the Topo Sort
// Step 2- Remove nodes from stack and relax the edges
import java.util.*;
public class L19_ShortestPathDAG {
    static class Pair {
        int node;
        int weight;
        Pair (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void topoSort(int curr_node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> st) {
        visited[curr_node] = true;
        for (int i=0;i<adj.get(curr_node).size();i++) {
            int v = adj.get(curr_node).get(i).node;
            if (!visited[v])
                topoSort(v, adj, visited, st);
        }
        st.add(curr_node);
    }
    public static void main(String[] args) {
        try {
            int V = 6, E = 7;
            int[][] edges = new int[][]{{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<V;i++) {
                List<Pair> temp = new ArrayList<>();
                adj.add(temp);
            }
            for (int i=0;i<E;i++)
                adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            
            // Perform Topo Sort using DFS
            boolean[] visited = new boolean[V];
            Stack<Integer> st = new Stack<>();
            for (int i=0;i<V;i++) {
                if (!visited[i])
                    topoSort(i, adj, visited, st);
            }

            // Relaxing the edges
            int[] distance = new int[V];
            Arrays.fill(distance, (int)1e9);
            distance[0] = 0;
            while (!st.isEmpty()) {
                int curr_node = st.peek();
                st.pop();
                for (int i=0;i<adj.get(curr_node).size();i++) {
                    int v = adj.get(curr_node).get(i).node;
                    int wt = adj.get(curr_node).get(i).weight;
                    if (distance[curr_node] + wt < distance[v])
                        distance[v] = distance[curr_node] + wt;
                }
            }

            for (int i=0;i<V;i++) {
                if (distance[i] == (int)1e9)
                    System.out.print(-1 + " ");
                else
                    System.out.print(distance[i] + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
