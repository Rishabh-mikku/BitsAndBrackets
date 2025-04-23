import java.util.*;
public class C1_TwoDishes {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int s = sc.nextInt();
                int max_abs = Integer.MIN_VALUE;
                for (int t1=0;t1<=n;t1++) {
                    int t2 = s - t1;
                    if (t2 >= 0 && t2 <= n)
                        max_abs = Math.max(max_abs, Math.abs(t1 - t2));
                }
                System.out.println(max_abs);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}