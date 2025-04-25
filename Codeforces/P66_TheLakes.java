import java.util.*;
public class P66_TheLakes {
    static int sum = 0;
    static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void dfs (int row, int col, int[][] grid, int[] delrow, int[] delcol, boolean[][] visited) {
        visited[row][col] = true;
        sum += grid[row][col];
        for (int i=0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] != 0 && !visited[nrow][ncol]) {
                dfs(nrow, ncol, grid, delrow, delcol, visited);
            }
        }
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[][] grid = new int[n][m];
                for (int i=0;i<n;i++) {
                    for (int j=0;j<m;j++) {
                        grid[i][j] = sc.nextInt();
                    }
                }
                boolean[][] visited = new boolean[n][m];
                int maxDepth = 0;
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, 1, 0, -1};
                for (int i=0;i<n;i++) {
                    for (int j=0;j<m;j++) {
                        if (grid[i][j] != 0 && !visited[i][j]) {
                            sum = 0;
                            dfs(i, j, grid, delrow, delcol, visited);
                            maxDepth = Math.max(maxDepth, sum);
                        }
                    }
                }
                System.out.println(maxDepth);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
