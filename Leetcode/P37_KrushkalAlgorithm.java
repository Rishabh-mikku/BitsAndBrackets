import java.util.*;
class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n) {
        for (int i=0;i<=n;i++) {
            size.add(1);
            parent.add(i);
        }
    }
    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        int ultimateParent = findUPar(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.add(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.add(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Edge implements Comparable<Edge> {
    int wt, src, dest;
    Edge(int wt, int src, int dest) {
        this.wt = wt;
        this.src = src;
        this.dest = dest;
    }
    public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
    }
}
public class P37_KrushkalAlgorithm {
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
            int[][] graphEdges = new int[][]{{0,1,5}, {1,2,3}, {0,2,1}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<V;i++)
                adj.add(new ArrayList<>());
            for (int[] edge : graphEdges) {
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
            }

            List<Edge> edges = new ArrayList<>();
            for (int i=0;i<V;i++) {
                for (Pair p : adj.get(i)) {
                    int adjNode = p.first;
                    int edWt = p.second;
                    Edge temp = new Edge(edWt, i, adjNode); 
                    edges.add(temp);
                }
            }
            DisjointSet ds = new DisjointSet(V);
            Collections.sort(edges);
            int mstWt = 0;
            
            for (int i=0;i<edges.size();i++) {
                int wt = edges.get(i).wt;
                int u = edges.get(i).src;
                int v = edges.get(i).dest;
                if (ds.findUPar(u) != ds.findUPar(v)) {
                    mstWt += wt;
                    ds.unionBySize(u, v);
                }
            }
            System.out.println(mstWt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
