import java.util.*;
public class P46_UnitArray {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int pos_count = 0, neg_count = 0;
                for (int i=0;i<n;i++) {
                    a[i] = sc.nextInt();
                    if (a[i] == -1)
                        neg_count++;
                    else
                        pos_count++;
                }
                int opr = 0;
                while (pos_count < neg_count || neg_count % 2 == 1) {
                    pos_count++;
                    neg_count--;
                    opr++;
                }
                System.out.println(opr);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
