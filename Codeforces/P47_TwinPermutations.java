import java.util.*;
public class P47_TwinPermutations {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i=0;i<n;i++)
                    a[i] = sc.nextInt();
                for (int i=0;i<n;i++)
                    System.out.print(n + 1 - a[i] + " ");
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
