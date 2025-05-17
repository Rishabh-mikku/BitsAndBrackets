import java.util.*;
public class P87_HackingNumbers2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            outer:
            while (t-- > 0) {
                long n = sc.nextLong();
                String[] operations = {"mul 9", "digit", "digit", "add " + (n - 9), "!"};
                for (String str : operations) {
                    System.out.println(str);
                    System.out.flush();
                    String resp = sc.next();
                    if (resp.equals("-1")) break outer;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
