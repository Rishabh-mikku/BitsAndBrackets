import java.util.*;
public class P52_Patapim {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[][] grid = new int[n][n];
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++)
                        grid[i][j] = sc.nextInt();
                }
                int[] a = new int[2 * n];
                boolean[] f = new boolean[2 * n + 1];
                Arrays.fill(a, -1);
                a[0] = 0;
                // int k = 1;
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++) {
                        int idx = i + j + 1;
                        if (a[idx] == -1) {
                            a[idx] = grid[i][j];
                            f[grid[i][j]] = true;
                        }
                    }
                }
                for (int i=1;i<2*n+1;i++) {
                    if (!f[i]) {
                        a[0] = i;
                        break;
                    }
                }
                for (int i=0;i<2*n;i++)
                    System.out.print(a[i] + " ");
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
