import java.util.*;
public class P26_SequenceGame {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] b = new int[n];
                for (int i=0;i<n;i++) {
                    b[i] = sc.nextInt();
                }
                List<Integer> a = new ArrayList<>();
                a.add(b[0]);
                for (int i=1;i<n;i++) {
                    if (b[i] < b[i-1]) {
                        if (b[i] == 1)
                            a.add(1);
                        else
                            a.add(b[i] - 1);
                    } 
                    a.add(b[i]);
                }

                System.out.println(a.size());
                for (int i=0;i<a.size();i++) {
                    System.out.print(a.get(i) + " ");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}