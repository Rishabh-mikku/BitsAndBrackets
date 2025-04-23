import java.util.*;
public class C2_Motivation {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int max_imdb = 0;
                for (int i=1;i<=n;i++) {
                    int s = sc.nextInt();
                    int r = sc.nextInt();
                    if (s <= x) {
                        max_imdb = Math.max(max_imdb, r);
                    }
                }
                System.out.println(max_imdb);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
