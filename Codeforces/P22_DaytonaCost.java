import java.util.*;
public class P22_DaytonaCost {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++) {
                    arr[i] = sc.nextInt();
                }

                boolean flag = false;
                for (int i=0;i<n;i++) {
                    int count_k = 0;
                    for (int j=i;j<n;j++) {
                        if (arr[j] == k) {
                            count_k++;
                        }
                        if (count_k >= (j - i + 1) - count_k) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag)
                    System.out.println("YES");
                else    
                    System.out.println("NO");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}