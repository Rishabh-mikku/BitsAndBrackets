import java.util.*;
public class P61_NewYearTransportation {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int t = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i=0;i<n-1;i++) {
                arr.add(sc.nextInt());
            }
            int pos = 1, next = 1;
            while (pos < t) {
                next = pos + arr.get(pos-1);
                pos = next;
            } 
            if (pos == t)
                System.out.println("YES");
            else
                System.out.println("NO");
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    } 
}
