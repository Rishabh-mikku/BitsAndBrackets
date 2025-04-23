import java.util.*;
public class P16_CoverInWater {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String str = sc.next();
                
                int empty_cell = 0;
                int cons_emptycell = 0, count=0;
                for (int i=0;i<n;i++) {
                    if (str.charAt(i) == '.') {
                        empty_cell++;
                        count++;
                        cons_emptycell = Math.max(cons_emptycell, count);
                    } else {
                        cons_emptycell = Math.max(cons_emptycell, count);
                        count = 0;
                    }
                }
                if (cons_emptycell >= 3)
                    System.out.println("2");
                else
                    System.out.println(empty_cell);
            }
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
