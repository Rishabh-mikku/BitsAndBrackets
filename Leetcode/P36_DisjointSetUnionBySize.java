import java.util.*;
class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i=0;i<=n;i++) {
            size.add(1);
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
public class P36_DisjointSetUnionBySize {
    public static void main(String[] args) {
        try {
            DisjointSet ds = new DisjointSet(7);
            ds.unionBySize(1, 2);
            ds.unionBySize(2, 3);
            ds.unionBySize(4, 5);
            ds.unionBySize(6, 7);
            ds.unionBySize(5, 6);

            // Check if 3 & 7 belong to same component or not
            if (ds.findUPar(3) == ds.findUPar(7))
                System.out.println("Same");
            else
                System.out.println("Not Same");
            
            ds.unionBySize(3, 7);
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
