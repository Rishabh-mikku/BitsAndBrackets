import java.util.*;
public class P43_KokoEatingBananas {
    public static int help(int[] arr, int k) {
        int totalHrs = 0;
        for (int i=0;i<arr.length;i++) {
            totalHrs += Math.ceil((double) arr[i] / k);
        }
        return totalHrs;
    }
    public static void main(String[] args) {
        try {
            int[] piles = new int[]{3,6,7,11};
            int h = 8;
            int n = piles.length;
            int maxElement = piles[0];
            for (int i=1;i<n;i++) {
                maxElement = Math.max(maxElement, piles[i]);
            }
            for (int k=1;k<=maxElement;k++) {
                int reqTime = help(piles, k);
                if (reqTime <= h) {
                    System.out.println(k);
                    return;
                }
            }
            System.out.println(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
