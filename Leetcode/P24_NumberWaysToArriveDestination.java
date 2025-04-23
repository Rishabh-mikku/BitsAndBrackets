import java.util.*;
public class P24_NumberWaysToArriveDestination {
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
            int mod = (int)(1e9 + 7);
            int n = 7;
            int[][] roads = new int[][]{{0,6,7}, {0,1,2}, {1,2,3}, {1,3,3}, {6,3,3}, {3,5,1}, {6,5,1}, {2,5,1}, {0,4,5}, {4,6,2}};
            
            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<n;i++)
                adj.add(new ArrayList<>());
            for (int i=0;i<roads.length;i++) {
                adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
                adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
            }
            int[] ways = new int[n];
            int[] distance = new int[n];
            Arrays.fill(ways, 0);
            Arrays.fill(distance, (int)1e9);
            ways[0] = 1;
            distance[0] = 0;
            PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> (x.first - y.first));
            q.add(new Pair(0, 0));

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int dist = p.first;
                int curr_node = p.second;
                for (Pair itr : adj.get(curr_node)) {
                    int adjNode = itr.first;
                    int adjW = itr.second;
                    if (dist + adjW < distance[adjNode]) {
                        distance[adjNode] = dist + adjW;
                        q.add(new Pair(distance[adjNode], adjNode));
                        ways[adjNode] = ways[curr_node];
                    } else if (dist + adjW == distance[adjNode]) {
                        ways[adjNode] = (ways[adjNode] + ways[curr_node]) % mod;
                    }
                }
            }
            System.out.println(ways[n-1] % mod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
