import java.util.*;

public class P41_SkibidiTable {
    public static long sol(int n, int a, int b) {
        long ans = 0;
        while (n > 1) {
            int x = 1 << (n - 1);
            long s = 1L << (2 * (n - 1));
            if (a <= x && b <= x) {
                // stay in same block
            } else if (a > x && b > x) {
                ans += s;
                a -= x;
                b -= x;
            } else if (a > x && b <= x) {
                ans += 2 * s;
                a -= x;
            } else {
                ans += 3 * s;
                b -= x;
            }
            n--;
        }
        if (a == 1 && b == 1) return ans + 1;
        if (a == 2 && b == 2) return ans + 2;
        if (a == 2 && b == 1) return ans + 3;
        return ans + 4;
    }

    public static int[] func(int n, long x) {
        int row = 0, col = 0;
        while (n > 1) {
            int p = 1 << (n - 1);
            long q = 1L << (2 * (n - 1));
            if (x <= q) {
                // stay in same block
            } else if (x <= 2 * q) {
                x -= q;
                row += p;
                col += p;
            } else if (x <= 3 * q) {
                x -= 2 * q;
                row += p;
            } else {
                x -= 3 * q;
                col += p;
            }
            n--;
        }
        if (x == 1) {
            row += 1;
            col += 1;
        } else if (x == 2) {
            row += 2;
            col += 2;
        } else if (x == 3) {
            row += 2;
            col += 1;
        } else {
            row += 1;
            col += 2;
        }
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();
                while (q-- > 0) {
                    String str = sc.next();
                    if (str.equals("->")) {
                        int a = sc.nextInt();
                        int b = sc.nextInt();
                        System.out.println(sol(n, a, b));
                    } else {
                        long p = sc.nextLong();
                        int[] x = func(n, p);
                        System.out.println(x[0] + " " + x[1]);
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
