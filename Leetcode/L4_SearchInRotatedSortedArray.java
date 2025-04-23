// 1- Identify the sorted half - left/right w.r.t. mid
// 2- Check whether target is present in sorted half
// 3- If not present then eliminate sorted half and proceed further
public class L4_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            }
            // Identify the sorted half
            // Right sorted half
            if (arr[mid] <= arr[high]) {
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            // Left sorted half
            else {
                if (arr[low] <= target && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        System.out.println("-1");
    }
}
