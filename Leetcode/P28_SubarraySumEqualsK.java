import java.util.*;
public class P28_SubarraySumEqualsK {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{1,2,3,-3,1,1,1,4,2,-3};
            int k = 3;
            int n = nums.length;
            int prefixSum = 0, count = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int i=0;i<n;i++) {
                prefixSum += nums[i];
                int remove = prefixSum - k;
                if (mp.containsKey(remove))
                    count += mp.get(remove);
                mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
