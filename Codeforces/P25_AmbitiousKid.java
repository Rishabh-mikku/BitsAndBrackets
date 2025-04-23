import java.util.*;
public class P25_AmbitiousKid {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            int min_opr = Integer.MAX_VALUE;
            for (int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
                min_opr = Math.min(min_opr, Math.abs(arr[i]));
            }
            System.out.println(min_opr);
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
