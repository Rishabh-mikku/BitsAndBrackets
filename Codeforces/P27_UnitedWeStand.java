import java.util.*;
public class P27_UnitedWeStand {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i=0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }
                List<Integer> b = new ArrayList<>();
                List<Integer> c = new ArrayList<>();
                Arrays.sort(ar);
                c.add(ar[n-1]);
                for (int i=n-2;i>=0;i--) {
                    if (ar[i] == ar[n-1])
                        c.add(ar[i]);
                    else
                        b.add(ar[i]);
                }

                if (b.size() == 0 || c.size() == 0) {
                    System.out.println("-1");
                    continue;
                }
                System.out.println(b.size() + " " + c.size());
                for (int i=0;i<b.size();i++)
                    System.out.print(b.get(i) + " ");
                System.out.println();
                for (int i=0;i<c.size();i++)
                    System.out.print(c.get(i) + " ");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}