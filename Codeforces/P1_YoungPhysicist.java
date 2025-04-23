import java.util.Scanner;

public class P1_YoungPhysicist {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int i=0;i<n;i++) {
                for (int j=0;j<3;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int flag = 0;
            for (int j=0;j<3;j++) {
                int col_sum = 0;
                for (int i=0;i<n;i++) {
                    col_sum = col_sum + arr[i][j];
                }
                if (col_sum != 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1)
                System.out.println("NO");
            else
                System.out.println("YES");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}