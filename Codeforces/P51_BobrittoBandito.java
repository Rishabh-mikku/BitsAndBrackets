import java.util.*;
public class P51_BobrittoBandito {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (n == m) {
                    System.out.println(l + " " + r);
                    continue;
                }
                int l_dash = 0;
                while (m > 0 && l_dash > l+1) {
                    l_dash--;
                    m--;
                }
                int r_dash = 0;
                while (m > 0 && r_dash < r) {
                    r_dash++;
                    m--;
                }
                System.out.println(l_dash + " " + r_dash);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
