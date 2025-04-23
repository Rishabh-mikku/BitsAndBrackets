public class P33_CountSubIslands {
    static int flag = 1;
    public static void dfs(int row, int col, int[][] grid1, int[][] grid2) {
        // Base Case
        if (row < 0 || row == grid2.length || col < 0 || col == grid2[0].length || grid2[row][col] == 0)
            return;
        if (grid1[row][col] == 0)
            flag = 0;
        grid2[row][col] = 0;
        dfs(row-1, col, grid1, grid2);
        dfs(row, col+1, grid1, grid2);
        dfs(row+1, col, grid1, grid2);
        dfs(row, col-1, grid1, grid2);
    }
    public static void main(String[] args) {
        try {
            int[][] grid1 = new int[][]{{1,1,1,0,0}, {0,1,1,1,1}, {0,0,0,0,0}, {1,0,0,0,0}, {1,1,0,1,1}};
            int[][] grid2 = new int[][]{{1,1,1,0,0}, {0,0,1,1,1}, {0,1,0,0,0}, {1,0,1,1,0}, {0,1,0,1,0}};
            int m = grid1.length;
            int n = grid1[0].length;

            int sub_islands = 0;
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (grid2[i][j] == 1) {
                        flag = 1;
                        dfs(i, j, grid1, grid2);
                        sub_islands += flag;
                    }
                }
            }
            System.out.println(sub_islands);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
