import java.util.Scanner;

public class C6_Start180 {
    static final long mod = 998244353;
    static final int MAX_N = 1000000; 
    static long[] powerOf2 = new long[MAX_N + 1];

    public static void precomputePowers() {
        powerOf2[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            powerOf2[i] = (powerOf2[i - 1] * 2) % mod;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            precomputePowers();
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                long res;

                if (n % 2 == 1) {
                    res = powerOf2[n - 1]; 
                } else {
                    res = (3 * powerOf2[n - 2]) % mod;
                }
                System.out.println(res);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
