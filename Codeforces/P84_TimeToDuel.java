import java.util.*;

public class P84_TimeToDuel {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n + 1];
                for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

                int[] edges = new int[n];
                Arrays.fill(edges, -1);
                List<List<Integer>> ls = new ArrayList<>(n);
                for (int i = 0; i < n; i++) ls.add(new ArrayList<>());

                Deque<int[]> dq = new ArrayDeque<>();
                for (int i = 1; i <= n; i++) {
                    if (arr[i] == 0) {
                        if (i > 1) dq.add(new int[]{i - 1, 1});
                        if (i < n) dq.add(new int[]{i, 0});
                    } else {
                        if (i == 1) dq.add(new int[]{1, 1});
                        else if (i == n) dq.add(new int[]{n - 1, 0});
                        else ls.get(i - 1).add(i);
                    }
                }

                boolean flag = false;
                while (!dq.isEmpty() && !flag) {
                    int[] x = dq.poll();
                    int idx = x[0], value = x[1];
                    if (edges[idx] == -1) {
                        edges[idx] = value;
                        if (value == 1) {
                            for (int a : ls.get(idx)) {
                                dq.add(new int[]{a, 1});
                            }
                        }
                    } else if (edges[idx] != value) {
                        flag = true;
                    }
                }
                System.out.println(flag ? "YES" : "NO");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
