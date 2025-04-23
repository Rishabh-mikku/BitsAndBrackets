import java.util.*;
public class C3_StockPrices {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int s = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                double inc_dec = s * c / 100.0;
                double curr_price = s + inc_dec;
                if (curr_price >= a && curr_price <= b)
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
