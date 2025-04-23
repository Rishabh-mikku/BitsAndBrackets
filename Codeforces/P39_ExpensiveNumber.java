import java.util.*;
public class P39_ExpensiveNumber {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                String n = sc.next();
                int count = 0, rem = 0;
                for (int i=0;i<n.length();i++) {
                    if (n.charAt(i) == '0')
                        count++;
                    else
                        rem = Math.max(rem, count+1);
                }
                System.out.println(n.length() - rem);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
