import java.util.*;
public class P70_CycleRoot {
    static class DSU {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DSU(int n) {
            for (int i=0;i<n;i++) {
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
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] p = new int[n];
                for (int i=0;i<n;i++) {
                    p[i] = sc.nextInt();
                    p[i]--;
                }
                String s = sc.next();
                DSU dsu = new DSU(n);
                for (int i=0;i<n;i++) {
                    dsu.unionBySize(i, p[i]);
                }

                // Mapping between parent and elements
                Map<Integer, List<Integer>> groupMap = new HashMap<>();
                for (int i=0;i<n;i++) {
                    int parent = dsu.findUPar(i);
                    groupMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
                }

                // Counting black for each parent
                Map<Integer, Integer> blackCount = new HashMap<>();
                for (Map.Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {
                    int parent = entry.getKey();
                    List<Integer> list = entry.getValue();
                    int count = 0;
                    for (int x : list) {
                        if (s.charAt(x) == '0')
                            count++;
                    }
                    blackCount.put(parent, count);
                }
                int[] ans = new int[n];
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<n;i++) {
                    int parent = dsu.findUPar(i);
                    sb.append(blackCount.get(parent)).append(" ");
                }
                System.out.println(sb);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
