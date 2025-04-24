import java.util.*;

public class P60_CherryBomb {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                for (int i = 0; i < n; i++) a[i] = sc.nextInt();
                for (int i = 0; i < n; i++) b[i] = sc.nextInt();

                boolean fixed = false, flag = true;
                long x = -1, left = 0, right = Long.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (b[i] != -1) {
                        long str = (long) a[i] + b[i];
                        if (!fixed) {
                            fixed = true;
                            x = str;
                        } else if (str != x) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println(0);
                    continue;
                }

                if (fixed) {
                    for (int i = 0; i < n; i++) {
                        if (b[i] == -1) {
                            long bi = x - a[i];
                            if (bi < 0 || bi > k) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    System.out.println(flag ? 1 : 0);
                } else {
                    for (int i = 0; i < n; i++) {
                        left = Math.max(left, a[i]);
                        right = Math.min(right, (long) a[i] + k);
                    }
                    System.out.println(right >= left ? right - left + 1 : 0);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
