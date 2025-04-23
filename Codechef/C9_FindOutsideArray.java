import java.util.*;

public class C9_FindOutsideArray {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++)
                    a[i] = sc.nextInt();
                Set<Long> vis = new HashSet<>();
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    vis.add((long) a[i]);
                    min = Math.min(min, a[i]);
                    max = Math.max(max, a[i]);
                }
                long s_min = 1L * min + min;
                if (!vis.contains(s_min)) {
                    System.out.println(min + " " + min);
                    continue;
                }
                long s_max = 1L * max + max;
                if (!vis.contains(s_max)) {
                    System.out.println(max + " " + max);
                    continue;
                }
                Arrays.sort(a);
                boolean flag = false;
                int l = Math.min(n, 100);
                int[] b = Arrays.copyOf(a, l);
                for (int i = 0; i < l; i++) {
                    for (int j = i; j < l; j++) {
                        long sum = 1L * b[i] + b[j];
                        if (!vis.contains(sum)) {
                            System.out.println(b[i] + " " + b[j]);
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                        break;
                }
                if (!flag)
                    System.out.println(-1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
