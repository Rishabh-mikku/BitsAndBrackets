import java.util.*;
public class P57_PrependAppend {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();
                int i = 0;
                for (;i<n/2;i++) {
                    if ((s.charAt(i) == '0' && s.charAt(n-i-1) == '0') || (s.charAt(i) == '1' && s.charAt(n-i-1) == '1'))
                        break;
                }              
                System.out.println(n - (2 * i));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
