import java.util.*;
public class P52_BipartiteGraphDFS {
    static boolean dfs(int node, int n, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;
        for (int adjNode : adj.get(node)) {
            if (color[adjNode] == -1) {
                if (!dfs(adjNode, n, 1-col, color, adj))
                    return false;
            }
            else if (color[adjNode] == col)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            // int[][] graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
            int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
            int n = graph.length;

            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<n;i++) {
                adj.add(new ArrayList<>());
            }
            for (int i=0;i<n;i++) {
                for (int j=0;j<graph[i].length;j++) {
                    adj.get(i).add(graph[i][j]);
                }
            }

            int[] color = new int[n];
            Arrays.fill(color, -1);
            for (int i=0;i<n;i++) {
                if (color[i] == -1) {
                    if (!dfs(i, n, 0, color, adj)) {
                        System.out.println(false);
                        return;
                    }
                }
            }
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
