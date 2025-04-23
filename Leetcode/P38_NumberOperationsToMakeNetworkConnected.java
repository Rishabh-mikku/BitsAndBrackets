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
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class P38_NumberOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        try {
             int n = 6;
             int[][] connections = new int[][]{{0,1}, {0,2}, {0,3}, {1,2}, {1,3}};

             int extraEdges = 0;
             DisjointSet ds = new DisjointSet(n);
             for (int i=0;i<connections.length;i++) {
                int u = connections[i][0];
                int v = connections[i][1];
                if (ds.findUPar(u) == ds.findUPar(v)) {
                    extraEdges++;
                } else {
                    ds.unionBySize(u, v);
                }
             }
             int numComponents = 0;
             for (int i=0;i<n;i++) {
                if (ds.parent.get(i) == i)
                    numComponents++;
             }
             int ans = numComponents - 1;
             if (extraEdges >= ans)
                System.out.println(ans);
             else
                System.out.println(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
