import java.util.*;
public class L12_01Matrix {
    static class Pair {
        int row;
        int column;
        int dist;
        Pair(int row, int column, int dist) {
            this.row = row;
            this.column = column;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        try {
            int[][] mat = new int[][]{{0,0,0}, {0,1,0}, {1,1,1}};
            int m = mat.length;
            int n = mat[0].length;
            int[][] visited = new int[m][n];
            int[][] distance = new int[m][n];
            Queue<Pair> q = new LinkedList<>();
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (mat[i][j] == 0) {
                        q.add(new Pair(i, j, 0));
                        visited[i][j] = 1;
                    } else {
                        visited[i][j] = 0;
                    }
                }
            }

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Pair p = q.remove();
                int curr_row = p.row;
                int curr_col = p.column;
                int curr_dist = p.dist;
                distance[curr_row][curr_col] = curr_dist;
                for (int i=0;i<4;i++) {
                    int r = curr_row + delrow[i];
                    int c = curr_col + delcol[i];
                    if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] == 0) {
                        q.add(new Pair(r, c, curr_dist+1));
                        visited[r][c] = 1;
                    }
                }
            }

            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) 
                    System.out.print(distance[i][j] + " ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
