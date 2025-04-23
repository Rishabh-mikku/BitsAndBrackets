import java.util.*;
public class L22_ShortestDistanceBinaryMaze {
    static class Tuple {
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static void main(String[] args) {
        try {
            int[][] grid = new int[][]{{1,1,1,1}, {1,1,0,1}, {1,1,1,1}, {1,1,0,0}, {1,0,0,1}};
            int n = grid.length;
            int m = grid[0].length;
            int src[] = new int[]{0, 1};
            int[] destination = new int[]{2, 2};

            if (src[0] == destination[0] && src[1] == destination[1]) {
                System.out.println(0);
                return;
            }

            int[][] distance = new int[n][m];
            for (int i=0;i<n;i++)
                Arrays.fill(distance[i], (int)1e9);
            distance[src[0]][src[1]] = 0;
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, src[0], src[1]));
            
            int[] delrow  = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Tuple t = q.poll();
                int dist = t.first;
                int row = t.second;
                int col = t.third;
                for (int i=0;i<4;i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && 1 + dist < distance[nrow][ncol]) {
                        distance[nrow][ncol] = 1 + dist;
                        if (nrow == destination[0] && ncol == destination[1]) {
                            System.out.println(dist + 1);
                            return;
                        }
                        q.add(new Tuple(distance[nrow][ncol], nrow, ncol));
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
