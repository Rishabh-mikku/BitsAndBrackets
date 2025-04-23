import java.util.*;
public class L13_SurroundedRegions {
    public static void dfs(int row, int column, char[][] board, int[][] visited, int[] delrow, int[] delcol) {
        visited[row][column] = 1;
        for (int i=0;i<4;i++) {
            int n_row = row + delrow[i];
            int n_col = column + delcol[i];
            if (n_row >=0 && n_row < board.length && n_col >=0 && n_col < board[0].length && visited[n_row][n_col] == 0 && board[n_row][n_col] == '0')
                dfs(n_row, n_col, board, visited, delrow, delcol);
        }
    }
    public static void main(String[] args) {
        try {
            char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', '0', '0', 'X'}, {'X', 'X', '0', 'X'}, {'X', '0', 'X', 'X'}};
            int m = board.length;
            int n = board[0].length;
            int[][] visited = new int[m][n];
            int delrow[] = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int j=0;j<n;j++) {
                // Top row
                if (visited[0][j] == 0 && board[0][j] == '0')
                    dfs(0, j, board, visited, delrow, delcol);
                // Bottom row
                if (visited[m-1][j] == 0 && board[m-1][j] == '0')
                    dfs(m-1, j, board, visited, delrow, delcol);
            }

            for (int i=0;i<m;i++) {
                // Left column
                if (visited[i][0] == 0 && board[i][0] == '0')
                    dfs(i, 0, board, visited, delrow, delcol);
                // Right column
                if (visited[i][n-1] == 0 && board[i][n-1] == '0')
                    dfs(i, n-1, board, visited, delrow, delcol);
            }

            // Updating board
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (visited[i][j] == 0 && board[i][j] == '0')
                        board[i][j] = 'X';
                }
            }

            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
