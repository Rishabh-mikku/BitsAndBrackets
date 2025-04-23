import java.util.*;
public class L15_TopologicalSort {
    public static void dfs(int curr_node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[curr_node] = true;
        for (int x : adj.get(curr_node)) {
            if (!visited[x])
                dfs(x, adj, visited, st);
        }
        st.push(curr_node);
    }
    public static void main(String[] args) {
        try {   
            int V = 6, E = 6;
            int[][] edges = new int[][]{{1,3}, {2,3}, {4,1}, {4,0}, {5,0}, {5,2}};
            
            List<List<Integer>> adj = new ArrayList<>();
            for (int i=0;i<V;i++) 
                adj.add(new ArrayList<>());
            for (int[] edge : edges)
                adj.get(edge[0]).add(edge[1]);
            boolean[] visited = new boolean[V];
            Stack<Integer> st = new Stack<>();
            for (int i=0;i<V;i++) {
                if (!visited[i])
                    dfs(i, adj, visited, st);
            }
            while (!st.isEmpty()) {
                System.out.print(st.pop() + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
