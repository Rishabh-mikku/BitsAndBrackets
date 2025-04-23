import java.util.*;
public class P40_SimpleRepetition {
    public static boolean checkPrime(long num) {
        if (num < 2)
            return false;
        if (num % 2 == 0)
            return num == 2;
        for (long i=3;i*i<=num;i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                long x = sc.nextLong();
                int k = sc.nextInt();
                if (k == 1) {
                    System.out.println(checkPrime(x) ? "Yes" : "No");
                    continue;
                }
                if (x != 1) {
                    System.out.println("No");
                    continue;
                }
                    
                long s = 0;
                for (int i=0;i<k;i++) 
                    s = s * 10 + 1;
                System.out.println(checkPrime(s) ? "Yes" : "No");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
} 