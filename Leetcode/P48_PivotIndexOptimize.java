import java.util.*;
public class P48_PivotIndexOptimize {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{1,7,3,6,5,6};
            int n = nums.length;
            int totalSum = 0;
            for (int x : nums) 
                totalSum += x;
            int leftSum = 0;
            for (int i=0;i<n;i++) {
                if (leftSum == totalSum - leftSum - nums[i]) {
                    System.out.println(i);
                    return;
                }
                leftSum += nums[i];
            }
            System.out.println(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
