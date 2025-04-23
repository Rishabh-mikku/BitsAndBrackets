import java.util.*;
public class C8_FlipPrefix {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();
                int a = 0, bal_prefix = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0')
                        a++;
                    else
                        a--;
                    if (a == 0)
                        bal_prefix++;
                }
                System.out.println(1 << bal_prefix);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}