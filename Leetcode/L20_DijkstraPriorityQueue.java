import java.util.*;
public class L20_DijkstraPriorityQueue {
    static class Pair {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static class PriorityPair {
        int dist;
        int node;
        PriorityPair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        try {
            int V = 3, src = 2;
            int[][] edges = new int[][]{{0,1,1}, {1,2,3}, {0,2,6}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<V;i++) {
                List<Pair> temp = new ArrayList<>();
                adj.add(temp);
            }
            for (int i=0;i<edges.length;i++) {
                adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
                adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
            }
            int[] distance = new int[V];
            Arrays.fill(distance, (int)1e9);
            distance[src] = 0;
            PriorityQueue<PriorityPair> q = new PriorityQueue<>((x, y) -> x.dist - y.dist);
            q.add(new PriorityPair(0, src));

            while (!q.isEmpty()) {
                PriorityPair p = q.peek();
                int curr_dist = p.dist;
                int curr_node = p.node;
                q.remove();
                for (int i=0;i<adj.get(curr_node).size();i++) {
                    int adjWeight = adj.get(curr_node).get(i).dist;
                    int adjNode = adj.get(curr_node).get(i).node;
                    if (curr_dist + adjWeight < distance[adjNode]) {
                        distance[adjNode] = curr_dist + adjWeight;
                        q.add(new PriorityPair(distance[adjNode], adjNode));
                    }
                }
            }
            for (int i=0;i<V;i++) {
                System.out.print(distance[i] + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
