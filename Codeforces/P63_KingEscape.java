import java.util.*;
public class P63_KingEscape {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int a_x = sc.nextInt();
            int a_y = sc.nextInt();
            int b_x = sc.nextInt();
            int b_y = sc.nextInt();
            int c_x = sc.nextInt();
            int c_y = sc.nextInt();

            // King - top, victory cell - below w.r.t. Queen
            if (b_x < a_x && c_x > a_x) {
                System.out.println("NO");
            }
            // King - below, victor cell - top w.r.t. Queen
            else if (b_x > a_x && c_x < a_x) {
                System.out.println("NO");
            } 
            // King - left, victory cell - right w.r.t. Queen
            else if (b_y < a_y && c_y > a_y) {
                System.out.println("NO");
            }
            // King - right, victory cell - left w.r.t. Queen
            else if (b_y > a_y && c_y < a_y) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
