import java.util.*;

public class P85_SliceToSurvive {
    static long help(long a) {
        return (a <= 1) ? 0 : 64 - Long.numberOfLeadingZeros(a - 1);
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                long n = sc.nextLong();
                long m = sc.nextLong();
                long a = sc.nextLong();
                long b = sc.nextLong();

                long p = a < n - a + 1 ? a : n - a + 1;
                long q = b < m - b + 1 ? b : m - b + 1;

                long r = 1 + help(m) + help(p);
                long s = 1 + help(n) + help(q);

                System.out.println(r < s ? r : s);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
