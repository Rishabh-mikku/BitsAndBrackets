import java.util.*;
public class P80_EverybodyLikesGoodArrays {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] arr = new long[n];
                for (int i=0;i<n;i++)
                    arr[i] = sc.nextLong();
                int consecutiveCount = 1;
                int ans = 0;
                for (int i=1;i<n;i++) {
                    if (arr[i] % 2 == arr[i-1] % 2) {
                        consecutiveCount++;
                    } else {
                        if (consecutiveCount >= 2) {
                            ans += consecutiveCount - 1;
                        }
                        consecutiveCount = 1;
                    }
                }
                if (consecutiveCount >= 2) {
                    ans += consecutiveCount - 1;
                }
                System.out.println(ans);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}