import java.util.*;
public class P21_PuzzlePrint {
    public static void main(String[] args) {
        List<String> p = List.of("pu", "zz", "le", " pr", "int", "ing");
        String res = "";
        for (String x : p) {
            res += x;
        }
        System.out.println(res);
    }
}