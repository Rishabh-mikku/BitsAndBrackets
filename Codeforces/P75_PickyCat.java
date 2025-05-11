import java.util.*;
public class P75_PickyCat {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] ar = new long[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }
                int min = 0, max = 0;
                for (int i=0;i<n;i++) {
                    if (Math.abs(ar[i]) > Math.abs(ar[0])) {
                        max++;
                    } else if (Math.abs(ar[i]) < Math.abs(ar[0])) {
                        min++;
                    }
                }
                int b = (int)Math.ceil(n / 2);
                if (max >= b || min <= b) {
                    System.out.println("YES");
                    continue;
                }
                System.out.println("NO");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
