import java.util.*;

public class P33_MinGcd {
    public static long gcdCal(long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                }

                long x = a[0];
                for (int i = 1; i < n; i++) {
                    if (a[i] < x)
                        x = a[i];
                }

                int dCount = 0;
                long[] list = new long[n];
                boolean[] min_list = new boolean[n];

                for (int i = 0; i < n; i++) {
                    if (a[i] % x == 0) {
                        list[dCount] = a[i] / x;
                        min_list[dCount] = a[i] == x;
                        dCount++;
                    }
                }

                if (dCount < 2) {
                    System.out.println("No");
                    continue;
                }

                long ar = list[0];
                for (int i = 1; i < dCount; i++) {
                    ar = gcdCal(ar, list[i]);
                }

                if (ar != 1) {
                    System.out.println("No");
                    continue;
                }

                long[] prefix = new long[dCount];
                long[] suffix = new long[dCount];
                prefix[0] = list[0];
                for (int i = 1; i < dCount; i++) {
                    prefix[i] = gcdCal(prefix[i - 1], list[i]);
                }
                suffix[dCount - 1] = list[dCount - 1];
                for (int i = dCount - 2; i >= 0; i--) {
                    suffix[i] = gcdCal(suffix[i + 1], list[i]);
                }

                boolean flag = false;
                for (int i = 0; i < dCount; i++) {
                    if (min_list[i]) {
                        long p = 0;
                        if (i > 0)
                            p = prefix[i - 1];
                        if (i < dCount - 1) {
                            if (p == 0)
                                p = suffix[i + 1];
                            else
                                p = gcdCal(p, suffix[i + 1]);
                        }
                        if (p == 1) {
                            flag = true;
                            break;
                        }
                    }
                }

                System.out.println(flag ? "Yes" : "No");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
