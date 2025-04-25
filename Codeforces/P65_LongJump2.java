import java.util.*;
public class P65_LongJump2 {
    public static int sol(int idx, int n, int[] arr, int[] dp) {
        // Base Case
        if (idx >= n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int pick = arr[idx] + sol(idx+arr[idx], n, arr, dp);
        return dp[idx] = pick;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++) {
                    arr[i] = sc.nextInt();
                }
                int maxSum = 0;
                int[] dp = new int[n];
                Arrays.fill(dp, -1);
                for (int i=0;i<n;i++) {
                    maxSum = Math.max(maxSum, sol(i, n, arr, dp));
                }
                System.out.println(maxSum);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
