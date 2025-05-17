import java.util.*;
public class P86_HackingNumbers1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            outer:
            while (t-- > 0) {
                long m = sc.nextLong();
                String[] ops = {"mul 9", "digit", "digit", "add " + (m - 9), "!"};
                for (String op : ops) {
                    System.out.println(op);
                    System.out.flush();
                    String str = sc.next();
                    if (str.equals("-1"))
                        break outer;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
