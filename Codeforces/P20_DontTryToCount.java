import java.util.*;
public class P20_DontTryToCount {

    public static boolean check(String x, String s) {
        if (x.length() < s.length())
            return false;
        for (int i=0;i<x.length()-s.length()+1;i++) {
            if (x.substring(i, i+s.length()).equals(s))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                String x = sc.next();
                String s = sc.next();

                String x0 = x;          // 0 operation
                String x1 = x0 + x0;    // 1 operation
                String x2 = x1 + x1;    // 2 operation
                String x3 = x2 + x2;    // 3 operation
                String x4 = x3 + x3;    // 4 operation
                String x5 = x4 + x4;    // 5 operation

                int ans = -1;
                if (check(x0, s)) 
                    ans = 0;
                else if (check(x1, s))
                    ans = 1;
                else if (check(x2, s))
                    ans = 2;
                else if (check(x3, s))
                    ans = 3;
                else if (check(x4, s))
                    ans = 4;
                else if (check(x5, s))
                    ans = 5;
                else
                    ans = -1;
                System.out.println(ans);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
