// Identify the sorted half of the array
// Find minimum element in the sorted half and then eliminate the sorted half
public class L5_MinElementSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int low = 0, high = arr.length-1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
