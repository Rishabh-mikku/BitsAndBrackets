import java.util.*;
public class P11_Contest1014 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String a = sc.next();
                String b = sc.next();

                int one_a = 0, one_b = 0;
                for (int i=0;i<n;i++) {
                    if ((i + 1) % 2 == 1) {
                        if (a.charAt(i) == '1')
                            one_a++;
                    } else {
                        if (a.charAt(i) == '1')
                            one_b++;
                    }
                    
                    if ((i + 1) % 2 == 1) {
                        if (b.charAt(i) == '1')
                            one_b++;
                    } else {
                        if (b.charAt(i) == '1')
                            one_a++;
                    }
                }

                int c_a = n / 2;
                int c_b = n - (n / 2);
                if (one_a <= c_a && one_b <= c_b)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
