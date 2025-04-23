import java.util.*;
public class L10_DetectCycle {
    static class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean detectCycle(int curr_node, List<List<Integer>> adj, boolean[] visited) {
        visited[curr_node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr_node, -1));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int p_node = p.node;
            int p_parent = p.parent;
            for (int adjNode : adj.get(p_node)) {
                if (!visited[adjNode]) {
                    q.add(new Pair(adjNode, p_node));
                    visited[adjNode] = true;
                } else if (adjNode != p_node) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            int V = 4, E = 4;
            int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<V;i++)
                adj.add(new ArrayList<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[V];
            for (int i=0;i<V;i++) {
                if (!visited[i]) {
                    if (detectCycle(i, adj, visited)) {
                        System.out.println("True");
                        return;
                    }
                }
            }
            System.out.println("False");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
