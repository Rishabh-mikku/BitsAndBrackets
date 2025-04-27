import java.util.*;
public class P50_PivotIndexAdvanceBS {
    static int[] prefixSum;
    static void preprocess(int[] arr, int n) {
        prefixSum = new int[n+1];
        for (int i=0;i<n;i++) {
            prefixSum[i+1] = arr[i] + prefixSum[i];
        }
    }
    static int findPivotIndex(int[] arr, int L, int R, int n) {
        int low = L, high = R;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int leftSum = prefixSum[mid] - prefixSum[L];
            int rightSum = prefixSum[R+1] - prefixSum[mid+1];
            if (leftSum == rightSum) {
                return mid;
            } else if (leftSum < rightSum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[] nums = new int[]{1,7,3,6,5,6};
            int n = nums.length;
            int q = 3;
            preprocess(nums, n);
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
