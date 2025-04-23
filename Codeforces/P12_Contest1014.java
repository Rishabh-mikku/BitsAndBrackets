import java.util.*;
public class P12_Contest1014 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }

                int max = ar[0], count_o = 0, sum = 0;
                for (int i=0;i<n;i++) {
                    if (ar[i] % 2 == 1)
                        count_o++;
                    max = Math.max(max, ar[i]);
                    sum += ar[i];
                }
                // if (count_o == 0 || count_o == n) 
                //     System.out.println(max);
                // else
                //     System.out.println(sum - (count_o - 1));
                System.out.println((count_o == 0 || count_o == n) ? max : (sum - (count_o - 1)));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
