import java.util.*;

public class P3_QueueAtSchool {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int t = sc.nextInt();
            String s = sc.nextLine();
            while (t-- > 0) {
                for (int i=0;i<n-1;i++) {
                    if (s.charAt(i) == 'B' && s.charAt(i+1) == 'G') {
                        char temp = s.charAt(i);
                        s = s.substring(0, i) + s.charAt(i+1) + s.substring(i+1);
                        s = s.substring(0, i) + temp + s.substring(i+1);
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
