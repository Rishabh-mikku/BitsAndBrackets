import java.util.*;
public class P45_GrasshopperOnLine {
    public static void main(String[] args) {
        try { 
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int x = sc.nextInt();
                int k = sc.nextInt();
                if (x % k != 0) {
                    System.out.println(1);
                    System.out.println(x);
                    continue;
                }
                System.out.println(2);
                System.out.println(x - 1 + " " + 1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
