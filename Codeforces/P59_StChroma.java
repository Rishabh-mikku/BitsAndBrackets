import java.util.*;

public class P59_StChroma {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] arr = new int[n];

                if (x == 0) {
                    for (int i = 0; i < n - 1; i++) arr[i] = i + 1;
                } else if (x == n) {
                    for (int i = 0; i < n; i++) arr[i] = i;
                } else {
                    int k = 0;
                    for (; k < x; k++) arr[k] = k;
                    for (int i = x + 1; i < n; i++, k++) arr[k] = i;
                    arr[k] = x;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]);
                    if (i + 1 != n) sb.append(" ");
                }
                System.out.println(sb);
        }
        sc.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
