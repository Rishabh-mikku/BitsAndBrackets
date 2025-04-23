import java.util.*;
public class P44_ForbiddenInteger {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int x = sc.nextInt();
                if (k == 1 && x == 1) {
                    System.out.println("NO");
                    continue;
                }
                if (x != 1) {
                    System.out.println("YES");
                    System.out.println(n);
                    for (int i=0;i<n;i++)
                        System.out.print(1 + " ");
                    System.out.println();
                    continue;
                }
                if (k >= 2 && x != 2 && n % 2 == 0) {
                    System.out.println("YES");
                    int d = n / 2;
                    System.out.println(d);
                    for (int i=0;i<d;i++)
                        System.out.print(2 + " ");
                    System.out.println();
                    continue;
                }
                // n -> odd
                if (x == 1 && k == 2 && n % 2 == 1) {
                    System.out.println("NO");
                    continue;
                }
                if (k > 2) {
                    System.out.println("YES");
                    String res = "";
                    for (int i=1;i<=k;i++) {
                        if (i != x && i % 2 == 1) {
                            n = n - i;
                            res += i;
                            break;
                        }
                    }
                    int d = n / 2;
                    for (int i=0;i<d;i++)
                        res += 2;
                    System.out.println(res.length());
                    for (int i=0;i<res.length();i++)
                        System.out.println(res.charAt(i) + " ");
                    continue;
                }
                if (x == 2) 
                    System.out.println("NO");
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}