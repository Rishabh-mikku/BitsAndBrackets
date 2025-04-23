import java.util.*;
public class P30_BattleshipsInBoard {
    public static void dfs(int row, int col, char[][] board, int[] delrow, int[] delcol) {
        board[row][col] = '.';
        for (int i=0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && board[nrow][ncol] == 'X') {
                dfs(nrow, ncol, board, delrow, delcol);
            }
        }
    }
    public static void main(String[] args) {
        try {
            char[][] board = new char[][]{{'X','.','.','X'}, {'.','.','.','X'}, {'.','.','.','X'}};
            int m = board.length;
            int n = board[0].length;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            int num_battleships = 0;
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (board[i][j] == 'X') {
                        num_battleships++;
                        dfs(i, j, board, delrow, delcol);
                    }
                }
            }
            System.out.println(num_battleships);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
