import java.util.*;
public class P2_BeautifulMatrix {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[][] matrix = new int[5][5];
            int one_i = 0, one_j = 0;
            for (int i=0;i<5;i++) {
                for (int j=0;j<5;j++) {
                    matrix[i][j] = sc.nextInt();
                    if (matrix[i][j] == 1) {
                        one_i = i;
                        one_j = j;
                    }
                }
            }

            int diff_i = Math.abs(2 - one_i);
            int diff_j = Math.abs(2 - one_j);
            System.out.println(diff_i + diff_j);
            sc.close(); 
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
