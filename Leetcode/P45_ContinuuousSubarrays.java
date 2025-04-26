import java.util.*;
public class P45_ContinuuousSubarrays {
    public static void main(String[] args) {
        try {
            // int[] nums = new int[]{5,4,2,4};
            int[] nums = {1, 2, 3};
            int n = nums.length;
            int no_subarray = 0;
            for (int i=0;i<n;i++) {
                int min = nums[i];
                int max = nums[i];
                for (int j=0;j<n;j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    if (max - min > 2)
                        break;
                    no_subarray++;
                }
            }
            System.out.println(no_subarray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
