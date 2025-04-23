import java.util.*;
public class P29_PartitionToKEqualSumSubsets {
    public static boolean help(int idx, int bucketNum, int bucketSum, int reqSum, int k, int[] nums, boolean[] visited) {
        if (bucketNum == k)
            return true;
        if (bucketSum == reqSum)
            return help(0, bucketNum+1, 0, reqSum, k, nums, visited);
        if (bucketSum > reqSum)
            return false;
        if (idx >= nums.length)
            return false;
        if (visited[idx]) {
            return help(idx+1, bucketNum, bucketSum, reqSum, k, nums, visited);
        } else {
            // pick
            bucketSum += nums[idx];
            visited[idx] = true;
            boolean pick = help(idx+1, bucketNum, bucketSum, reqSum, k, nums, visited);

            // not pick
            bucketSum -= nums[idx];
            visited[idx] = false;
            boolean not_pick = help(idx+1, bucketNum, bucketSum, reqSum, k, nums, visited);

            return pick || not_pick;
        }
    }
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{4,3,2,3,5,2,1};
            int k = 4;
            
            int n = nums.length;
            boolean[] visited = new boolean[n];
            int total_sum = 0;
            for (int x : nums)
                total_sum += x;
            if (total_sum % k != 0) {
                System.out.println("False");
                return;
            }
            total_sum /= k;
            
            if (help(0, 0, 0, total_sum, k, nums, visited))
                System.out.println("True");
            else
                System.out.println("False");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
