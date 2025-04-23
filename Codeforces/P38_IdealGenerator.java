import java.util.*;
public class P38_IdealGenerator {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int k = sc.nextInt();
                if (k % 2 == 0) {
                    System.out.println("No");
                    continue;
                }
                System.out.println("Yes");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
