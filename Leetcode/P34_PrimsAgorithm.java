import java.util.*;
public class P34_PrimsAgorithm {
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        try {
            int V = 3, E = 3;
            int[][] grid = new int[][]{{0,1,5}, {1,2,3}, {0,2,1}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<V;i++)
                adj.add(new ArrayList<>());
            for (int[] edge : grid) {
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
            }

            PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> (x.first - y.first));
            boolean[] visited = new boolean[V];
            q.add(new Pair(0, 0));
            int sum = 0;

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int wt = p.first;
                int node = p.second;
                if (visited[node])
                    continue;
                visited[node] = true;
                sum += wt;
                // for (int i=0;i<adj.get(node).size();i++) {
                //     int edWt = adj.get(node).get(i).second;
                //     int adjNode = adj.get(node).get(i).first;
                //     if (!visited[adjNode]) {
                //         q.add(new Pair(edWt, adjNode));
                //     }
                // }
                
                for (Pair edge : adj.get(node)) {
                    int edWt = edge.second;
                    int adjNode = edge.first;
                    if (!visited[adjNode])
                        q.add(new Pair(edWt, adjNode));
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
