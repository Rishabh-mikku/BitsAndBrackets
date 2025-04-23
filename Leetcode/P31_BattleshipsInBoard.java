public class P31_BattleshipsInBoard {
    public static void main(String[] args) {
        try {
            char[][] board = new char[][]{{'X','.','.','X'}, {'.','.','.','X'}, {'.','.','.','X'}};
            int m = board.length;
            int n = board[0].length;

            int num_battleships = 0;
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    if (board[i][j] != 'X')
                        continue;
                    if (i > 0 && board[i-1][j] == 'X')
                        continue;
                    if (j > 0 && board[i][j-1] == 'X')
                        continue;
                    num_battleships++;
                }
            }
            System.out.println(num_battleships);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
