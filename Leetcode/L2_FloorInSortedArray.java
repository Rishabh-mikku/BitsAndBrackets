public class L2_FloorInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{80, 59, 26, 46};
        int x = 28;
        int low = 0, high = arr.length-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else 
                high = mid - 1;
        }
        System.out.println(ans);
    }
}