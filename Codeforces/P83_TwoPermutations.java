import java.util.*;
public class P83_TwoPermutations {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a + b + 2 <= n || (a == n && b == n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
