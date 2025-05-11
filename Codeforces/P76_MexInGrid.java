import java.util.*;
public class P76_MexInGrid {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[][] grid = new int[n][n];
                
                int a = 0, b = n - 1;
                int c = 0, d = n - 1;
                int x = 0;

                while (a <= b && c <= d) {
                    for (int i = c; i <= d; i++) {
                        grid[a][i] = x++;
                    }
                    a++;

                    if (a <= b) {
                        for (int i = a; i <= b; i++) {
                            grid[i][d] = x++;
                        }
                        d--;
                    }

                    if (c <= d) {
                        for (int i = d; i >= c; i--) {
                            grid[b][i] = x++;
                        }
                        b--;
                    }

                    if (a <= b) {
                        for (int i = b; i >= a; i--) {
                            grid[i][c] = x++;
                        }
                        c++;
                    }
                }

                int max = n * n - 1;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result.append(max - grid[i][j]).append(" ");
                    }
                    result.append("\n");
                }
                
                System.out.print(result.toString());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
