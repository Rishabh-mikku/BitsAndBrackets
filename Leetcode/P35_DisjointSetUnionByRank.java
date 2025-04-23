import java.util.*;
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i=0;i<=n;i++) {
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        int ultimate_parent = findUPar(parent.get(node));
        parent.set(node, ultimate_parent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}
public class P35_DisjointSetUnionByRank {
    public static void main(String[] args) {
        try {
            DisjointSet ds = new DisjointSet(7);
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);

            // Check if 3 & 7 belong to same component or not
            if (ds.findUPar(3) == ds.findUPar(7))
                System.out.println("Same");
            else
                System.out.println("Not Same");
            
            ds.unionByRank(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7))
                System.out.println("Same");
            else
                System.out.println("Not Same");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
