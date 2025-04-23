import java.util.*; 
public class L8_RottingOranges {
    public static void main(String[] args) {
        try {
            int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
            int m = grid.length;
            int n = grid[0].length;
            Queue<Pair> q = new LinkedList<>();
            int count_fresh = 0;

            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (grid[i][j] == 2)
                        q.add(new Pair(i, j, 0));
                    if (grid[i][j] == 1)
                        count_fresh++;
                }
            }

            int time_taken = 0;
            int count = 0;
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Pair x = q.poll();
                int curr_row = x.row;
                int curr_col = x.column;
                int curr_time = x.time;
                time_taken = Math.max(time_taken, curr_time);

                for (int i=0;i<4;i++) {
                    int r = curr_row + delrow[i];
                    int c = curr_col + delcol[i];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new Pair(r, c, curr_time+1));
                        count++;
                    }
                }
            }

            if (count != count_fresh) {
                System.out.println(-1);
                return;
            }
            System.out.println(time_taken);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static class Pair {
        int row;
        int column;
        int time;
        Pair(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }
}