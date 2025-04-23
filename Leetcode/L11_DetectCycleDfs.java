import java.util.*;
public class L11_DetectCycleDfs {

    public static boolean detectCycleDfs(int curr_node, int parent_node, List<List<Integer>> adj, boolean[] visited) {
        visited[curr_node] = true;
        for (int adjNode : adj.get(curr_node)) {
            if (!visited[adjNode]) {
                if (detectCycleDfs(adjNode, curr_node, adj, visited))
                    return true;
            } else if (adjNode != parent_node)
                return true;
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
            for (int edge[] : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[0]).add(edge[1]);
            }

            boolean[] visited = new boolean[V];
            for (int i=0;i<V;i++) {
                if (!visited[i]) {
                    if (detectCycleDfs(i, -1, adj, visited)) {
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
