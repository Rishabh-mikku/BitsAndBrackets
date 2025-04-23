import java.util.*;
public class P42_MinMaxMEX {
    public static boolean checkParition(int x, int[] a, int k) {
        if (x == 0)
            return true;
        int count_part = 0;
        int[] vis = new int[x];
        int version = 1;
        int temp = x;
        for (int num : a) {
            if (num < x && vis[num] != version) {
                vis[num] = version;
                temp--;
            }
            if (temp == 0) {
                count_part++;
                if (count_part >= k) 
                    return true;
                version++;
                temp = x;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] a = new int[n];
                for (int i=0;i<n;i++) {
                    a[i] = sc.nextInt();
                }
                Map<Integer, Integer> freq = new HashMap<>();
                for (int x : a) {
                    freq.put(x, freq.getOrDefault(x, 0) +  1);
                }
                int x = 0;
                while (freq.getOrDefault(x, 0) >= k) {
                    x++;
                }
                int low = 0, high = x + 1;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (checkParition(mid, a, k)) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                System.out.println(low - 1);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
