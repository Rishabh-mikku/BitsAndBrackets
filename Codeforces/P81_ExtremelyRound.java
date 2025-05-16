import java.util.*;
public class P81_ExtremelyRound {
    static boolean calDigits(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 != 0)
                count++;
            if (count == 2)
                return false;
            n /= 10;
        }   
        return true;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (n <= 10) {
                    System.out.println(n);
                } else {
                    int count = 10;
                    for (int i=11;i<=n;i++) {
                        if (calDigits(i))
                            count++;
                    }
                    System.out.println(count);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
