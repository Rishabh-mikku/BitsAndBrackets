import java.util.*;
public class P15_LineTrip {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] ar = new int[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }

                int max_dist = ar[0];
                for (int i=1;i<n;i++) {
                    max_dist = Math.max(max_dist, ar[i] - ar[i-1]);
                }
                max_dist = Math.max(max_dist, 2 * (x - ar[n-1]));
                System.out.println(max_dist);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}