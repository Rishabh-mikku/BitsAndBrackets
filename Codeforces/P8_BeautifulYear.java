import java.util.*;
public class P8_BeautifulYear {

    public static boolean isBeautifulYear(int y) {
        int[] digit = new int[4];
        int x = y;
        int i = 0;
        while (x != 0) {
            int d = x % 10;
            digit[i++] = d;
            x = x / 10;
        }
        Arrays.sort(digit);
        int flag = 0;
        for (int j=1;j<4;j++) {
            if (digit[j] == digit[j-1]) {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int year = sc.nextInt();
            year++;
            while (!isBeautifulYear(year)) {
                year++;
            }
            System.out.println(year);
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}