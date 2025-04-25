import java.util.*;
public class P69_SakurakosHobby {
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
                boolean[] visited = new boolean[n];
                int[] ans = new int[n];
                for (int i=0;i<n;i++) {
                    if (visited[i])
                        continue;
                    int u = i, count = 0;
                    List<Integer> path = new ArrayList<>();
                    while (!path.contains(u)) {
                        visited[u] = true;
                        path.add(u);
                        if (s.charAt(u) == '0')
                            count++;
                        u = p[u];
                    }
                    for (int x : path) {
                        ans[x] = count;
                    }
                }
                for (int i=0;i<n;i++)
                    System.out.print(ans[i] + " ");
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}