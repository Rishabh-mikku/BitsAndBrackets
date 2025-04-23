import java.util.Scanner;
public class P4_OlympiadDate {

    static boolean checkArray(int[] a) {
        int f = 0;
        for (int i=0;i<a.length;i++) {
            if (a[i] != 0) {
                f = 1;
                break;
            }
        }

        if (f == 1)
            return false;
        return true;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0;i<n;i++) {
                    arr[i] = sc.nextInt();
                }
                int[] a = {3, 1, 2, 1, 0, 1};
                int no_digits = 0;
                int flag = 0;

                for (int i=0;i<n;i++) {
                    no_digits++;
                    if (arr[i] < 6 && a[arr[i]] != 0) {
                        a[arr[i]]--;
                    }
                    if (checkArray(a)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1)
                    System.out.println(no_digits);
                else
                    System.out.println(0);
            }
            sc.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}