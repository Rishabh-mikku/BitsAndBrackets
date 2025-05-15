import java.util.*;
public class P78_OneTwo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                int count2 = 0;
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                    if (ar[i] == 2)
                        count2++;
                }
                if (count2 == 0) {
                    System.out.println(1);
                    continue;
                }
                if (count2 % 2 == 1) {
                    System.out.println(-1);
                    continue;
                }
                count2 /= 2;
                int cnt = 0;
                for (int i=0;i<n;i++) {
                    if (cnt == count2) {
                        System.out.println(i);
                        cnt = -1;
                        break;
                    }
                    if (ar[i] == 2)
                        cnt++;
                }
                if (cnt != -1) {
                    System.out.println(-1);
                    continue;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    } 
}
