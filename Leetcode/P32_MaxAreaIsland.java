public class P32_MaxAreaIsland {
    static int count = 0;
    public static void dfs(int row, int col, int[][] grid, int[] delrow, int[] delcol) {
        grid[row][col] = 0;
        count++;
        for (int i=0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, delrow, delcol);
            }
        }
    }
    public static void main(String[] args) {
        try {
            int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
            // int[][] grid = new int[][]{{0,0,0,0,0,0,0,0}};
            int m = grid.length;
            int n = grid[0].length;

            int maxArea_island = 0;
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (grid[i][j] == 1) {
                        count = 0;
                        dfs(i, j, grid, delrow, delcol);
                        maxArea_island = Math.max(maxArea_island, count);
                    }
                }
            }
            System.out.println(maxArea_island);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
