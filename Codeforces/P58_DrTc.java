import java.util.*;
public class P58_DrTc {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();
                long count = 0;
                for (int i=0;i<s.length();i++) {
                    if (s.charAt(i) == '1')
                        count++;
                }
                long res = count * (n - 2L) + n;
                System.out.println(res);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
