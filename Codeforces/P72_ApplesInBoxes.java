import java.util.*;

public class P72_ApplesInBoxes {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long k = sc.nextLong();
                long[] a = new long[n];
                long max = Long.MIN_VALUE, min = Long.MAX_VALUE, s = 0;
                int count = 0;

                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                    s += a[i];

                    if (a[i] > max) {
                        max = a[i];
                        count = 1;
                    } else if (a[i] == max) {
                        count++;
                    }

                    if (a[i] < min) {
                        min = a[i];
                    }
                }

                boolean c1 = (max - min) > (k + 1);
                boolean c2 = (max - min) == (k + 1) && count > 1;

                if (c1 || c2) {
                    System.out.println("Jerry");
                } else {
                    System.out.println((s & 1) == 1 ? "Tom" : "Jerry");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
