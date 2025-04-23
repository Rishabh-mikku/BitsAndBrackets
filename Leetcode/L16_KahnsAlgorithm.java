import java.util.*;
public class L16_KahnsAlgorithm {
    public static void main(String[] args) {
        try {
            // int V = 4, E = 3;
            // int[][] edges = new int[][]{{3,0},{1,0},{2,0}};
            int V = 4;
            int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {3,3}};
            List<Integer> res = new ArrayList<>();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<V;i++)
                adj.add(new ArrayList<>());
            for (int[] edge : edges)
                adj.get(edge[0]).add(edge[1]);
            int[] indegree = new int[V];
            for (int i=0;i<V;i++) {
                for (int x : adj.get(i)) 
                    indegree[x]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i=0;i<V;i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            while (!q.isEmpty()) {
                int curr_node = q.remove();
                res.add(curr_node);
                for (int x : adj.get(curr_node)) {
                    indegree[x]--;
                    if (indegree[x] == 0)
                        q.add(x);
                }
            }
            for (int i=0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
