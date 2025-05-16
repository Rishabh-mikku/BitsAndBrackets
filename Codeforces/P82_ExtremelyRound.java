import java.util.*;
public class P82_ExtremelyRound {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int ans = 0;
                if (n < 10) {
                    ans = n;
                } else if (n >= 10 && n <= 99) {
                    ans += (n / 10) + 9;
                } else if (n > 99 && n <= 999) {
                    ans += (n / 100) + (9 * 2);
                } else if (n > 999 && n <= 9999) {
                    ans += (n / 1000) + (9 * 3);
                } else if (n > 9999 && n <= 99999) {
                    ans += (n / 10000) + (9 * 4);
                } else if (n > 99999 && n <= 999999) {
                    ans += (n / (int)Math.pow(10, 5)) + (9 * 5);
                }
                System.out.println(ans);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
