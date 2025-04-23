import java.util.*;
public class P9_HalloumiBoxes {

    public static boolean isSorted(int[] ar) {
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
                int k = sc.nextInt();
                int[] ar = new int[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }
                if (isSorted(ar))
                    System.out.println("YES");
                else {
                    if (k == 1)
                        System.out.println("NO");
                    else 
                        System.out.println("YES");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}