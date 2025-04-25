import java.util.*;
public class P62_Badge {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            for (int i=0;i<n;i++) {
                boolean[] visited = new boolean[n+1];
                visited[i+1] = true;
                int j = arr[i];
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j-1];
                }
                ans[i] = j;
            }
            for (int i=0;i<n;i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
