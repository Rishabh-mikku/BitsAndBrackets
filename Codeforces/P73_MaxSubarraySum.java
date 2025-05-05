import java.util.*;
public class P73_MaxSubarraySum {
    final static long neg_inf = -1000000000000000000L;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long k = sc.nextLong();
                String s = sc.next();
                long[] a = new long[n];
                for (int i=0;i<n;i++) {
                    a[i] = sc.nextLong();
                }
                long curr = 0;
                long max = Long.MIN_VALUE;
                for (int i=0;i<n;i++) {
                    if (s.charAt(i) == '1') {
                        curr = Math.max(curr+a[i], a[i]);
                        max = Math.max(max, curr);
                        if (curr < 0)
                            curr = 0;
                    } else {
                        curr = 0;
                    }
                }

                if (max > k) {
                    System.out.println("NO");
                    continue;
                }

                int zero_loc = -1;
                for (int i=0;i<n;i++) {
                    if (s.charAt(i) == '0') {
                        zero_loc = i;
                        break;
                    }
                }
                if (zero_loc == -1) {
                    if (max == k) {
                        System.out.println("YES");
                        for (long x : a) {
                            System.out.print(x + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("NO");
                        continue;
                    }
                    
                }

                int j = zero_loc;
                long s_sum = 0;
                long maxi = Long.MIN_VALUE;
                boolean flag = false;
                for (int i=j-1;i>=0 && s.charAt(i)=='1';i--) {
                    s_sum += a[i];
                    maxi = Math.max(maxi, s_sum);
                    flag = true;
                }
                long l = flag ? maxi : 0;
                long p_sum = 0;
                long r_maxi = Long.MIN_VALUE;
                boolean flag_r = false;
                for (int i=j+1;i<n && s.charAt(i) == '1';i++) {
                    p_sum += a[i];
                    r_maxi = Math.max(r_maxi, p_sum);
                    flag_r = true;
                }
                long r = flag_r ? r_maxi : 0;

                long b;
                if (l >= 0 && r >= 0) {
                    b = k - l - r;
                } else if (l >=0 && r <= 0) {
                    b = k - l;
                } else if (l <= 0 && r >= 0) {
                    b = k - r;
                } else {
                    b = k;
                }

                System.out.println("YES");
                for (int i=0;i<n;i++) {
                    if (s.charAt(i) == '0') {
                        if (i == j)
                            System.out.print(b);
                        else
                            System.out.print(neg_inf);
                    } else {
                        System.out.print(a[i]);
                    }
                    System.out.print((i + 1 < n) ? " " : "\n");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
