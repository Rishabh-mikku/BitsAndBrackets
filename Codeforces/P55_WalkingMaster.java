import java.util.*;
public class P55_WalkingMaster {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int source_x = sc.nextInt();
                int source_y = sc.nextInt();
                int dest_x = sc.nextInt();
                int dest_y = sc.nextInt();
                
                if (dest_y < source_y) {
                    System.out.println(-1);
                    continue;
                }
                int moves = dest_y - source_y;
                source_x += moves;
                if (source_x < dest_x) {
                    System.out.println(-1);
                    continue;
                }
                moves += source_x - dest_x;
                System.out.println(moves);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
