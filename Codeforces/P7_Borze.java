import java.util.*;
public class P7_Borze {
    public static void main(String[] args) {
        try {
            Scanner sc= new Scanner(System.in);
            String str = sc.next();
            String res = "";
            for (int i=0;i<str.length();i++) {
                if (str.charAt(i) == '-' && str.charAt(i+1) == '.') {
                    res += "1";
                    i++;
                } else if (str.charAt(i) == '-' && str.charAt(i+1) == '-') {
                    res += "2";
                    i++;
                } else {
                    res += "0";
                }
            }
            System.out.println(res);
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
