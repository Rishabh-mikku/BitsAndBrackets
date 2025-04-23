import java.util.*;

public class P54_Boneca {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                int[] count = new int[30];
                for (int i = 0; i < n; i++) {
                    for (int b = 0; b < 30; b++) {
                        if ((a[i] & (1 << b)) != 0) {
                            count[b]++;
                        }
                    }
                }

                long max = 0;
                for (int i = 0; i < n; i++) {
                    long sum = 0;
                    for (int b = 0; b < 30; b++) {
                        if ((a[i] & (1 << b)) != 0) {
                            sum += (long)(n - count[b]) << b;
                        } else {
                            sum += (long)(count[b]) << b;
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }

                System.out.println(max);
            }

            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
