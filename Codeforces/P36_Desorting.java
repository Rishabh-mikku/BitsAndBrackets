import java.util.*;
public class P36_Desorting {

    public static boolean checkSort(int[] ar) {
        for (int i=1;i<ar.length;i++) {
            if (ar[i] < ar[i-1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }

                if (!checkSort(ar)) {
                    System.out.println("0");
                    continue;
                }
                int min_diff = Integer.MAX_VALUE;
                for (int i=1;i<n;i++) {
                    min_diff = Math.min(min_diff, ar[i] - ar[i-1]);
                }
                System.out.println(min_diff / 2 + 1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
