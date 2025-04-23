// 1 based indexing of graph
import java.util.*;
public class P21_PrintShortestPath {
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
            int V = 5, E = 6;
            int[][] edges = new int[][]{{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1}, {4,3,3}, {3,5,1}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<=V;i++)
                adj.add(new ArrayList<>());
            for (int i=0;i<E;i++) {
                adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
                adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
            }
            int[] distance = new int[V+1];
            Arrays.fill(distance, (int)1e9);
            int[] parent = new int[V+1];
            for (int i=0;i<=V;i++)
                parent[i] = i;
            PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.first - y.first);
            q.add(new Pair(0, 1));
            distance[1] = 0;
            
            while (!q.isEmpty()) {
                Pair p = q.remove();
                int curr_dist = p.first;
                int curr_node = p.second;
                for (int i=0;i<adj.get(curr_node).size();i++) {
                    int adjWeight = adj.get(curr_node).get(i).second;
                    int adjNode = adj.get(curr_node).get(i).first;
                    if (curr_dist + adjWeight < distance[adjNode]) {
                        distance[adjNode] = curr_dist + adjWeight;
                        q.add(new Pair(distance[adjNode], adjNode));
                        parent[adjNode] = curr_node;
                    }
                }
            }

            if (distance[V] == (int)1e9) {
                System.out.println("-1");
                return;
            }
            List<Integer> shortestPath = new ArrayList<>();
            int node = V;
            while (parent[node] != node) {
                shortestPath.add(node);
                node = parent[node];
            }
            shortestPath.add(1);
            Collections.reverse(shortestPath);

            for (int i=0;i<shortestPath.size();i++)
                System.out.print(shortestPath.get(i) + " ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
