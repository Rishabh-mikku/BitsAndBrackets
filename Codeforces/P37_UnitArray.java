import java.util.*;
public class P37_UnitArray {
    public static int countNeg(int[] ar) {
        int count_neg = 0;
        for (int i=0;i<ar.length;i++) {
            if (ar[i] < 0)
                count_neg++;
        }
        return count_neg;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int sum = 0;
                for (int i=0;i<n;i++) {
                    a[i] = sc.nextInt();
                    sum += a[i];
                }
                if (sum >= 0 && countNeg(a) % 2 == 0) {
                    System.out.println("0");
                    continue;
                }
                int opr = Math.abs(sum) / 2;
                if (Math.abs(sum) % 2 == 1)
                    opr += 1;
                if ((countNeg(a) - opr) % 2 == 1)
                    opr += 1;
                System.out.println(opr);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}