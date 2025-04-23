import java.util.*;
public class P6_QueueAtSchool {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int t = sc.nextInt();
            String str = sc.next();

            for (int i=1;i<=t;i++) {
                for (int j=1;j<n;j++) {
                    if (str.charAt(j) == 'G' && str.charAt(j-1) == 'B') {
                        char[] ar = str.toCharArray();
                        char temp = ar[j];
                        ar[j] = ar[j-1];
                        ar[j-1] = temp;
                        str = String.valueOf(ar);
                        j++;
                    }
                }
            }
            System.out.println(str);
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
