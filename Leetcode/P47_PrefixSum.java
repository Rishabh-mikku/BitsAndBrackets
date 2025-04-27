import java.util.*;
public class P47_PrefixSum {
    public static void main(String[] args) {
        try {
            // int[] nums = new int[]{1,7,3,6,5,6};
            // int[] nums = {1,2,3};
            int[] nums = {2,1,-1};
            int n = nums.length;
            int[] prefix_sum = new int[n];
            int suffix_sum[] = new int[n];
            prefix_sum[0] = nums[0];
            suffix_sum[n-1] = nums[n-1];
            for (int i=1;i<n;i++) {
                prefix_sum[i] = nums[i] + prefix_sum[i-1];
                suffix_sum[n-i-1] = nums[n-i-1] + suffix_sum[n-i];
            }
            for (int i=0;i<n;i++) {
                if (prefix_sum[i] == suffix_sum[i]) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
