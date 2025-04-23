import java.util.Scanner;

public class P56_NeedZero {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i=0;i<n;i++)
                    a[i] = sc.nextInt();
                int total_xor = 0;
                for (int i=0;i<n;i++)
                    total_xor ^= a[i];
                if (n % 2 == 1) {
                    System.out.println(total_xor);
                } else {
                    if (total_xor == 0)
                        System.out.println(total_xor);
                    else
                        System.out.println(-1);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
