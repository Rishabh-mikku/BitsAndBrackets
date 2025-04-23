import java.util.*;
public class P22_PathWithMinEffort {
    static class Tuple {
        int dist;
        int row;
        int col;
        Tuple(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        try {
            int[][] heights = new int[][]{{1,2,3}, {3,8,4}, {5,3,5}};
            int m = heights.length, n = heights[0].length;

            int distance[][] = new int[m][n];
            for (int i=0;i<m;i++)
                Arrays.fill(distance[i], (int)1e9);
            PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.dist - y.dist);
            distance[0][0] = 0;
            q.add(new Tuple(0,0,0));

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Tuple t = q.poll();
                int diff = t.dist;
                int row = t.row;
                int col = t.col;
                if (row == m-1 && col == n-1) {
                    System.out.println(diff);
                    return;
                }
                for (int i=0;i<4;i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                        int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col]), diff);
                        if (newEffort < distance[nrow][ncol]) {
                            distance[nrow][ncol] = newEffort;
                            q.add(new Tuple(distance[nrow][ncol], nrow, ncol));
                        }
                    }
                }
            }
            System.out.println(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}