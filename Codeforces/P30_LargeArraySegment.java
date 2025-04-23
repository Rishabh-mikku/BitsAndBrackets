import java.util.*;

public class P30_LargeArraySegment {
    static int countLeq(long[] arr, int n, long val) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= val)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long x = sc.nextLong();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            long[] P = new long[n];
            P[0] = 0;
            for (int i = 1; i < n; i++) {
                P[i] = P[i - 1] + a[i - 1];
            }
            
            long sumA = P[n - 1] + a[n - 1];
            
            if (k * sumA < x) {
                System.out.println(0);
                continue;
            }
            
            long T = k * sumA - x;
            long ans = 0;
            
            for (int copy = 0; copy < k; copy++) {
                long limit = T - (long) copy * sumA;
                if (limit < 0) {
                    break;
                }
                ans += countLeq(P, n, limit);
            }
            
            System.out.println(ans);
        }
        
        sc.close();
    }
}
