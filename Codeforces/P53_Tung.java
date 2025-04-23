import java.util.*;

public class P53_Tung {
    static class Pair {
        char a;
        int count;
        Pair(char a, int count) {
            this.a = a;
            this.count = count;
        }
    }

    public static List<Pair> sol(String str) {
        List<Pair> x = new ArrayList<>();
        if (str.length() == 0)
            return x;
        char curr = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == curr)
                cnt++;
            else {
                x.add(new Pair(curr, cnt));
                curr = str.charAt(i);
                cnt = 1;
            }
        }
        x.add(new Pair(curr, cnt));
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String p = sc.next();
            String s = sc.next();
            if (s.length() < p.length() || s.length() > 2 * p.length()) {
                System.out.println("NO");
                continue;
            }

            List<Pair> pStr = sol(p);
            List<Pair> sStr = new ArrayList<>();
            int idx = 0, cnt = 1;
            boolean flag = true;
            char curr = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == curr) {
                    cnt++;
                } else {
                    if (idx >= pStr.size() || curr != pStr.get(idx).a || cnt < pStr.get(idx).count || cnt > 2 * pStr.get(idx).count) {
                        flag = false;
                        break;
                    }
                    idx++;
                    curr = s.charAt(i);
                    cnt = 1;
                }
            }
            if (flag) {
                if (idx >= pStr.size() || curr != pStr.get(idx).a || cnt < pStr.get(idx).count || cnt > 2 * pStr.get(idx).count) {
                    flag = false;
                }
                idx++;
            }
            if (flag && idx != pStr.size()) flag = false;

            System.out.println(flag ? "YES" : "NO");
        }
        sc.close();
    }
}
