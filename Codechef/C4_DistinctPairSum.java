import java.util.*;
public class C4_DistinctPairSum {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int diff_lr = r - l;
                int sum = 0;
                for (int i=1;i<=diff_lr;i++) {
                    sum += i;
                }
                System.out.println(sum + diff_lr + 1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
