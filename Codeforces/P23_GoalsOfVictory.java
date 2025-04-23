import java.util.*;
public class P23_GoalsOfVictory {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n-1];
                int eff = 0;
                for (int i=0;i<n-1;i++) {
                    arr[i] = sc.nextInt();
                    eff += arr[i];
                }
                System.out.println(0 - eff);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
