import java.util.*;
public class P41_IncreasingArray {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{5,3,4,4,7,3,6,11,8,5,11};
            // int[] nums = {4,5,7,7,13};
            int n = nums.length;
            List<Integer> arr = new ArrayList<>();
            for (int i=0;i<n;i++) {
                arr.add(nums[i]);
            }
            int min_opr = 0;
            while(true) {
                List<Integer> toRemove = new ArrayList<>();
                for (int i=1;i<arr.size();i++) {
                    if (arr.get(i) < arr.get(i-1)) {
                        toRemove.add(i);
                    }
                }
                if (toRemove.size() == 0) {
                    System.out.println(min_opr);
                    return;
                }
                for (int i=toRemove.size()-1;i>=0;i--) {
                    arr.remove((int)toRemove.get(i));
                }
                min_opr++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
