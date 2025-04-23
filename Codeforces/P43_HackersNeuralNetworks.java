import java.util.*;
public class P43_HackersNeuralNetworks {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                String[] s = new String[n];
                for (int i = 0; i < n; i++) {
                    s[i] = sc.next();
                }
                BitSet vis = new BitSet(n);
                int f = 0;
                for (int i = 0; i < m; i++) {
                    int count = 0;
                    BitSet temp = new BitSet(n);
                    for (int j = 0; j < n; j++) {
                        String str = sc.next();
                        if (str.equals(s[j])) {
                            count++;
                            temp.set(j);
                        }
                    }
                    vis.or(temp);
                    f = Math.max(f, count);
                }
                System.out.println(vis.cardinality() == n ? 3 * n - 2 * f : -1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
