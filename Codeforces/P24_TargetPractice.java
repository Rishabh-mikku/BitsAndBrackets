import java.util.*;
public class P24_TargetPractice {

    final static int score[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
        {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
        {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
        {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
        {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
        {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
        {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
        {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0){
                char[][] arr = new char[10][10];
                for (int i=0;i<10;i++) {
                    String s = sc.next();
                    for (int j=0;j<10;j++)
                        arr[i][j] = s.charAt(j);
                }

                int points = 0;
                for (int i=0;i<10;i++) {
                    for (int j=0;j<10;j++) {
                        if (arr[i][j] == 'X')
                            points += score[i][j];
                    }
                }
                System.out.println(points);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
