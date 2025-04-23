import java.io.*;
import java.util.*;
public class P50_TrippiTroppi {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String s = br.readLine();
                String res = "";
                res += s.charAt(0);
                for (int i=1;i<s.length();i++) {
                    char c = s.charAt(i);
                    if (c == ' ')
                        res += s.charAt(i+1);
                }
                System.out.println(res);
            }
            br.close(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
