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
public class P40_AccountsMerge {
    public static void main(String[] args) {
        try {
            String[][] accounts = new String[][]{{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"}, {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};

            int m = accounts.length;
            DisjointSet ds = new DisjointSet(m);

            // 1 - Iterate through each email & create a mapping of email to the node which they are belonging to.
            HashMap<String, Integer> mapMailNode = new HashMap<>();
            for (int i=0;i<m;i++) {
                for (int j=1;j<accounts[i].length;j++) {
                    String mail = accounts[i][j];
                    if (!mapMailNode.containsKey(mail)) {
                        mapMailNode.put(mail, i);
                    } else {
                        ds.unionBySize(i, mapMailNode.get(mail));
                    }
                }
            }

            // 2 - Take the mail and put them in a list of merged String.
            List<String>[] mergedMail = new ArrayList[m];
            for (int i=0;i<m;i++)
                mergedMail[i] = new ArrayList<String>();
            for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
                String mail = it.getKey();
                int node = ds.findUPar(it.getValue());
                mergedMail[node].add(mail);
            }

            // 3 - Sort the mails for a particular node.
            List<List<String>> ans = new ArrayList<>();
            for (int i=0;i<m;i++) {
                if (mergedMail[i].size() == 0)
                    continue;
                Collections.sort(mergedMail[i]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts[i][0]);
                for (String it : mergedMail[i]) {
                    temp.add(it);
                }
                ans.add(temp);
            }

            // 4 - Print the merged accounts
            for (int i=0;i<ans.size();i++) {
                for (int j=0;j<ans.get(i).size();j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
