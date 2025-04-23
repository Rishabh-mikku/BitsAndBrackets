import java.util.*;
public class P28_Buttons {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (c % 2 == 1) {
                    a++;
                    if (a > b)
                        System.out.println("First");
                    else
                        System.out.println("Second");
                } else {
                    if (a > b)
                        System.out.println("First");
                    else
                        System.out.println("Second");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
