import java.util.*;
public class P32_MaxMod {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (n % 2 == 0) {
                    System.out.println("-1");
                    continue;
                }
                System.out.print(n + " " + 1);
                for (int i=3;i<=n;i++) {
                    System.out.print(" " + (i - 1));
                }
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
