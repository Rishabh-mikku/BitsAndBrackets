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
public class P39_MostStonesRemoved {
    public static void main(String[] args) {
        try {
            int[][] stones = new int[][]{{0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}};
            
            int m = stones.length;
            int maxRow = 0;
            int maxCol = 0;
            for (int i=0;i<m;i++) {
                maxRow = Math.max(maxRow, stones[i][0]);
                maxCol = Math.max(maxRow, stones[i][1]);
            }
            DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
            Map<Integer, Integer> stoneNodes = new HashMap<>(); // for unique parents
            /*
             * We just need the nodes in Disjoint Set which are
             * involved in having a stone. So we store the rows 
             * and columns in map as they will have stones.
             * And we just need to count them once for ultimate parents.
             */
            for (int i=0;i<m;i++) {
                int nodeRow = stones[i][0];
                int nodeCol = stones[i][1] + maxRow + 1;
                ds.unionBySize(nodeRow, nodeCol);
                stoneNodes.put(nodeRow, 1);
                stoneNodes.put(nodeCol, 1);
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()) {
                if (ds.findUPar(entry.getKey()) == entry.getKey())
                    count++;
            }
            System.out.println(m - count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
