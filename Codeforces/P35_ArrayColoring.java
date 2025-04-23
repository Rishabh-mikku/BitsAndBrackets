import java.util.*;
public class P35_ArrayColoring {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                int even_no = 0, odd_no = 0;
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                    if (ar[i] % 2 == 0)
                        even_no++;
                    else
                        odd_no++;
                }

                if (odd_no % 2 == 1) {
                    System.out.println("No");
                    continue;
                }
                System.out.println("Yes");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
