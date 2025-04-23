import java.util.*;
public class P49_Coins {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                long n = sc.nextLong();
                long k = sc.nextLong();
                if (k % 2 == 0) {
                    if (n % 2 != 0)
                        System.out.println("NO");
                    else
                        System.out.println("YES");
                    continue;
                }
                System.out.println("YES");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
