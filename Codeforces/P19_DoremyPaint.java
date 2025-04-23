import java.util.*;
public class P19_DoremyPaint {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                    mp.put(ar[i], mp.getOrDefault(ar[i], 0) + 1);
                }

                if (mp.size() >=3) {
                    System.out.println("NO");
                    continue;
                }
                if (mp.size() == 1) {
                    System.out.println("YES");
                    continue;
                }
                Iterator<Integer> it = mp.values().iterator();
                int v1 = it.next();
                int v2 = it.next();
                if (n % 2 == 0) {
                    if (v1 == v2)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                } else {
                    if (Math.abs(v1 - v2) == 1)
                        System.out.println("YES");
                    else
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