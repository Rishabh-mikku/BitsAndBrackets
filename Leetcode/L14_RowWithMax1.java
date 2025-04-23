import java.util.*;
public class L14_RowWithMax1 {
    public static int binarySearch(int[] arr, int n) {
        int low = 0, high = n-1;
        int first_o = -1, last_o = -1;
        // First occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                first_o = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        if (first_o == -1)
            return -1;
        return n-first_o;
    }
    public static void main(String[] args) {
        try {
            int[][] arr = new int[][]{{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
            // int[][] arr = {{0, 0}, {0, 0}};
            int n = arr.length;
            int row_idx = -1, max_1 = 0;
            for (int i=0;i<n;i++) {
                int res = binarySearch(arr[i], arr[i].length);
                // System.out.println(res);
                if (res > max_1) {
                    max_1 = res;
                    row_idx = i;
                }
            }
            System.out.println(row_idx);
        } catch (Exception e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
