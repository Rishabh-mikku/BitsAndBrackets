import java.util.*;
public class P77_ServalMochaArray {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
                int flag = 0;
                for (int i=0;i<n;i++) {
                    for (int j=i+1;j<n;j++) {
                        if (gcd(arr[i], arr[j]) <= 2) {
                            flag = 1;
                        }
                    }
                }
                if (flag == 1) {
                    System.out.println("YES");
                    continue;
                } 
                System.out.println("NO");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
