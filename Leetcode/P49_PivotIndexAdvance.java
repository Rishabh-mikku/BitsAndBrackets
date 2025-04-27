import java.util.*;
public class P49_PivotIndexAdvance {
    static int findPivotIndex(int arr[], int l, int r, int n) {
        int totalSum = 0;
        for (int i=l;i<=r;i++) {
            totalSum += arr[i];
        }
        int leftSum = 0;
        for (int i=l;i<=r;i++) {
            if (leftSum == totalSum - leftSum - arr[i])
                return i;
            leftSum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[] nums = new int[]{1,7,3,6,5,6};
            int n = nums.length;
            int q = 3;
            while (q-- > 0) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                System.out.println(findPivotIndex(nums, L, R, n));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
