import java.util.*;
public class P46_ContinuousSubarraysOptimize {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{5,4,2,4};
            int n = nums.length;
            int left = 0, window_size = 0, right = 0;
            long count_subarray = 0;
            int max_range = nums[0], min_range = nums[0];
            for (right=0;right<n;right++) {
                // Max and min elements in a subarray
                max_range = Math.max(max_range, nums[right]);
                min_range = Math.min(min_range, nums[right]);

                if (max_range - min_range > 2) {
                    window_size = right - left;
                    count_subarray += (window_size * (window_size + 1)) / 2;

                    left = right;
                    // Expand current window to as left as possible
                    min_range = nums[right];
                    max_range = nums[right];
                    while (Math.abs(nums[right] - nums[left-1]) <= 2) {
                        left--;
                        min_range = Math.min(min_range, nums[left]);
                        max_range = Math.max(max_range, nums[left]);
                    }
                    // Subtract overcounted array
                    if (left < right) {
                        window_size = right - left;
                        count_subarray -= (window_size * (window_size + 1)) / 2;
                    }
                }
            }
            // Add subarrays from last window
            window_size = right - left;
            count_subarray += (window_size * (window_size + 1)) / 2;
            System.out.println(count_subarray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
