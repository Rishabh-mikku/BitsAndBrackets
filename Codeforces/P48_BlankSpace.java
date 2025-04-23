import java.util.*;
public class P48_BlankSpace {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i=0;i<n;i++)
                    a[i] = sc.nextInt();
                
                int l = 0, r = 0;
                int cons_0 = 0;
                while (r < n) {
                    if (a[r] == 0) {
                        cons_0 = Math.max(cons_0, r-l+1);
                        r++;
                    }
                    else {
                        l = r+1;
                        r++;
                    }
                }
                System.out.println(cons_0);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
