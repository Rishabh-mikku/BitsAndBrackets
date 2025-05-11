import java.util.*;
public class P74_DinnerTime {
    public static void main(String[] args) {
        try {
            Scanner sc =  new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int p = sc.nextInt();
                int q = sc.nextInt();
                if (n % p == 0) {
                    int a = n / p;
                    if (m == a * q) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    continue;
                }
                System.out.println("YES");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
