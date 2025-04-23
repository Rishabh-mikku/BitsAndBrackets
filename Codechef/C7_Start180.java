import java.util.*;
public class C7_Start180 {

    public static void sol (int n, int k) {
        if (n == 1) {
            if (k == 1) 
                System.out.println("A\nA");
            else 
                System.out.println("A\nC");
            return;
        }

        if (k < n / 2 || k > n) {
            System.out.println("-1");
            return;
        }
            
        
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append((i % 2 == 0) ? 'A' : 'B');
        }

        StringBuilder s2 = new StringBuilder(s);
        int c = 0;
        for (int i=0;i<n && c<(n-k);i+=2) {
            s2.setCharAt(i, 'C');
            c++;
        }
        System.out.println(s);
        System.out.println(s2);
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                sol(n, k);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
