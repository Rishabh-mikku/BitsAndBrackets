import java.util.*;
public class P5_Contest {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++) {
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr);
                int teams = 0;
                int team_size = 0;

                for (int i=n-1;i>=0;i--) {
                    team_size++;
                    if (team_size * arr[i] >= x) {
                        teams++;
                        team_size = 0;
                    }
                }
                System.out.println(teams);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}