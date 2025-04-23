import java.util.*;

public class C10_TreeColoring {
    static final int N = 200005;
    static ArrayList<Integer>[] g = new ArrayList[N];
    static int[] sz = new int[N];
    static int[] col = new int[N];
    static int cid;

    static void clr(int n) {
        for (int i = 0; i < n; ++i) {
            g[i].clear();
            sz[i] = 0;
            col[i] = 0;
        }
        cid = 1;
    }

    static int dfs_sz(int u) {
        sz[u] = 1;
        for (int v : g[u]) sz[u] += dfs_sz(v);
        return sz[u];
    }

    static int dfs(int u) {
        List<Integer> rem = new ArrayList<>();
        for (int v : g[u]) {
            int r = dfs(v);
            if (r != -1) rem.add(r);
        }
        while (rem.size() > 1) {
            int a = rem.remove(rem.size() - 1);
            int b = rem.remove(rem.size() - 1);
            col[a] = col[b] = cid++;
        }
        if (u != 0) {
            if (!rem.isEmpty()) {
                col[u] = col[rem.get(0)] = cid++;
                return -1;
            }
            return u;
        } else {
            if (!rem.isEmpty()) {
                col[u] = col[rem.get(0)] = cid++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; ++i) g[i] = new ArrayList<>();
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                for (int i = 0; i < n - 1; ++i) sc.nextInt();
                System.out.println("-1");
                continue;
            }
            clr(n);
            for (int i = 1; i < n; ++i) {
                int p = sc.nextInt();
                g[p - 1].add(i);
            }
            dfs_sz(0);
            boolean ok = true;
            for (int i = 1; i < n; ++i) {
                if (sz[i] % 2 == 0) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println("-1");
                continue;
            }
            dfs(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) sb.append(col[i]).append(" ");
            System.out.println(sb);
        }
        sc.close();
    }
}
