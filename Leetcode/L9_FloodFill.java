import java.util.*;
public class L9_FloodFill {

    public static void outputImage(int[][] image) {
        for (int i=0;i<image.length;i++) {
            for (int j=0;j<image[0].length;j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
            int sr = 1, sc = 1, color = 2;

            if (image[sr][sc] == color) {
                outputImage(image);
                return;
            }
            int m = image.length;
            int n = image[0].length;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(sr, sc));
            int org_color = image[sr][sc];
            image[sr][sc] = color;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Pair x = q.poll();
                int curr_row = x.row;
                int curr_col = x.column;
                for (int i=0;i<4;i++) {
                    int r = curr_row + delrow[i];
                    int c = curr_col + delcol[i];
                    if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == org_color) {
                        q.add(new Pair(r, c));
                        image[r][c] = color;
                    }
                }
            }
            outputImage(image);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static class Pair {
        int row;
        int column;
        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}   