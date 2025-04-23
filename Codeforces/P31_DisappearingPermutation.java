import java.util.*;

public class P31_DisappearingPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            int[] d = new int[n + 1];
            
            for (int i = 1; i <= n; i++) p[i] = sc.nextInt();
            for (int i = 1; i <= n; i++) d[i] = sc.nextInt();
            
            int[] a = new int[n + 1];
            int[] size = new int[n + 1];
            int c = 0;

            for (int i = 1; i <= n; i++) {
                if (a[i] != 0) continue;
                c++;
                int curr = i, count = 0;
                
                while (a[curr] == 0) {
                    a[curr] = c;
                    count++;
                    curr = p[curr];
                }
                size[c] = count;
            }

            int[] f = new int[c + 1];
            long res = 0;

            for (int i = 1; i <= n; i++) {
                int idx = d[i];
                int x = a[idx];

                if (f[x] == 0) {
                    f[x] = 1;
                    res += size[x];
                }
                System.out.print(res + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
