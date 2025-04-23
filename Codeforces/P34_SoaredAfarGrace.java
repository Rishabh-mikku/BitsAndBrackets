import java.util.*;

public class P34_SoaredAfarGrace {

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n + 1];
                int[] b = new int[n + 1];
                for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
                for (int i = 1; i <= n; i++) b[i] = sc.nextInt();

                int[] x = new int[n + 1];
                for (int i = 1; i <= n; i++) x[a[i]] = i;

                int count = 0, idx = -1;
                for (int i = 1; i <= n; i++) {
                    if (a[i] == b[i]) {
                        count++;
                        idx = i;
                    }
                }

                if ((n % 2 == 0 && count != 0) || (n % 2 == 1 && count != 1)) {
                    System.out.println(-1);
                    continue;
                }

                boolean[] vis = new boolean[n + 1];
                int[] l = new int[n / 2];
                int[] r = new int[n / 2];
                int p_count = 0;
                boolean flag = true;

                for (int i = 1; i <= n; i++) {
                    if (a[i] == b[i] || vis[i]) continue;
                    int j = x[b[i]];
                    if (j == i || b[j] != a[i] || vis[j]) {
                        flag = false;
                        break;
                    }
                    l[p_count] = Math.min(i, j);
                    r[p_count] = Math.max(i, j);
                    vis[i] = vis[j] = true;
                    p_count++;
                }

                if (!flag || 2 * p_count != (n % 2 == 0 ? n : n - 1)) {
                    System.out.println(-1);
                    continue;
                }

                int[] s = new int[n + 1];
                int c_l = 1, c_r = n;
                for (int i = 0; i < p_count; i++) {
                    s[c_l++] = l[i];
                    s[c_r--] = r[i];
                }
                if (n % 2 == 1) s[(n + 1) / 2] = idx;

                int[] curr = new int[n + 1];
                int[] po = new int[n + 1];
                for (int i = 1; i <= n; i++) curr[i] = po[i] = i;

                List<int[]> op = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    if (curr[i] != s[i]) {
                        int j = po[s[i]];
                        swap(curr, i, j);
                        po[curr[i]] = i;
                        po[curr[j]] = j;
                        op.add(new int[]{i, j});
                    }
                }

                System.out.println(op.size());
                for (int[] i : op) System.out.println(i[0] + " " + i[1]);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
