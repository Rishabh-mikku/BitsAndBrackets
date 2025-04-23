import java.util.Scanner;
public class P18_JaggedSwaps {
    
    public static boolean isSorted(int[] a) {
        for (int i=1;i<a.length;i++) {
            if (a[i] < a[i-1])
                return false;
        }
        return true;
    }
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
                if (isSorted(ar)) {
                    System.out.println("YES");
                    continue;
                }
                    
                else {
                    int flag = 0;
                    for (int i=1;i<n-1;i++) {
                        if (ar[i] > ar[i-1] && ar[i] > ar[i+1]) {
                            flag = 1;
                            break;
                        }
                    }
                if (ar[0] == 1 && flag == 1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
            sc.close();
        } catch (Exception e) {
            return;
        }
    }
}