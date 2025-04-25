// "What is the maximum score I can get starting from index idx?"
import java.util.*;
public class P64_LongJumps {
    public static int sol(int idx, int[] arr, int n, int[] dp) {
        // Base Case
        if (idx >= n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int not_pick = sol(idx+1, arr, n, dp);
        int pick = arr[idx] + sol(idx+arr[idx], arr, n, dp);
        return dp[idx] = Math.max(not_pick, pick); 
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
                int[] dp = new int[n];
                Arrays.fill(dp, -1);
                int sum = sol(0, arr, n, dp);
                System.out.println(sum);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
