import java.util.*;

public class P71_LRCVIP {
    public static long GCD(long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] a = new long[n];
                Map<Long, Integer> freqMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                    freqMap.put(a[i], freqMap.getOrDefault(a[i], 0) + 1);
                }

                Set<Long> uniqueSet = freqMap.keySet();
                boolean flag = false;

                for (long x : uniqueSet) {
                    int count_1 = freqMap.get(x);
                    int count_2 = n - count_1;

                    if (count_1 > 0 && count_2 > 0) {
                        long b = 0;
                        for (long num : a) {
                            if (num != x) {
                                if (b == 0)
                                    b = num;
                                else
                                    b = GCD(b, num);
                            }
                        }

                        if (b != x) {
                            System.out.println("YES");
                            for (long num : a) {
                                if (num == x)
                                    System.out.print("1 ");
                                else
                                    System.out.print("2 ");
                            }
                            System.out.println();
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println("NO");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
