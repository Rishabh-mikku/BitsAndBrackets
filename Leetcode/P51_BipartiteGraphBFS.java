import java.util.*;
public class P51_BipartiteGraphBFS {
    static boolean bfs(int start, int[] color, List<List<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if (color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            int[][] graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
            // int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
            int m = graph.length;

            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<m;i++) {
                adj.add(new ArrayList<>());
            }
            for (int i=0;i<m;i++) {
                for (int j=0;j<graph[i].length;j++) {
                    adj.get(i).add(graph[i][j]);
                }
            }

            int[] color = new int[m];
            Arrays.fill(color, -1);
            for (int i=0;i<m;i++) {
                if (color[i] == -1) {
                    if (!bfs(i, color, adj, m)) {
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
