import java.util.*;
public class C5_MaxiOnes {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                String s = sc.next();
                int no_one = 0, no_zero = 0;
                int last1_idx = s.lastIndexOf('1');
                for (int i=0;i<n;i++) {
                    if (s.charAt(i) == '1')
                        no_one++;
                    if (i < last1_idx && s.charAt(i) == '0')
                        no_zero++;
                }
                if (no_zero <= k)
                    System.out.println(no_zero + no_one);
                else
                    System.out.println(k + no_one);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}  