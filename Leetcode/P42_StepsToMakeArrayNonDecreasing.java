import java.util.*;
public class P42_StepsToMakeArrayNonDecreasing {
    static class Pair {
        int element;
        int cnt;
        Pair (int element, int cnt) {
            this.element = element;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{5,3,4,4,7,3,6,11,8,5,11};
            int n = nums.length;
            Stack<Pair> st = new Stack<>();
            st.push(new Pair(nums[n-1], 0));
            int  min_opr = 0;
            for (int i=n-2;i>=0;i--) {
                int count = 0;
                while (!st.isEmpty() && nums[i] > st.peek().element) {
                    count = Math.max(count+1, st.peek().cnt);
                    st.pop();
                }
                min_opr = Math.max(min_opr, count);
                st.push(new Pair(nums[i], count));
            }
            System.out.println(min_opr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
