import java.util.*;
public class P79_MakeItBeautiful {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
                Arrays.sort(arr);
                int max = arr[n-1], min = arr[0];
                if (min == max) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                    System.out.print(max + " ");
                    for (int i=0;i<n-1;i++) 
                        System.out.print(arr[i] + " ");
                    System.out.println();
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
