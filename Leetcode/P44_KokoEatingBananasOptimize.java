import java.util.*;
public class P44_KokoEatingBananasOptimize {
    public static int findMax(int[] arr, int n) {
        int maxElement = arr[0];
        for (int i=1;i<n;i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }
    public static int findTotalHrs(int arr[], int n, int k) {
        int totalHrs = 0;
        for (int i=0;i<n;i++) {
            totalHrs += Math.ceil((double) arr[i] / k);
        }
        return totalHrs;
    }
    public static void main(String[] args) {
        try {
            int[] piles = new int[]{3,6,7,11};
            int h = 8;
            int n = piles.length;
            int low = 1, high = findMax(piles, n);
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int totalHrs = findTotalHrs(piles, n, mid);
                if (totalHrs <= h) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(low);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
