import java.util.*;

public class P14_Contest1014 {
    private static char getMissingLetter(char a, char b) {
        return (a == 'L' && b == 'I') || (a == 'I' && b == 'L') ? 'T' :
               (a == 'L' && b == 'T') || (a == 'T' && b == 'L') ? 'I' : 'L';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] sequence = sc.next().toCharArray();
            int length = sequence.length;
            
            int countL = 0, countI = 0, countT = 0;
            for (char c : sequence) {
                if (c == 'L') countL++;
                else if (c == 'I') countI++;
                else if (c == 'T') countT++;
            }
            
            if (countL == countI && countI == countT) {
                System.out.println(0);
                continue;
            }
            
            if (length == 1) {
                System.out.println(-1);
                continue;
            }
            
            int minOps = -1, targetCount = -1;
            for (int ops = 0; ops <= 2 * n; ops++) {
                if ((length + ops) % 3 != 0) continue;
                int target = (length + ops) / 3;
                if (target >= countL && target >= countI && target >= countT) {
                    minOps = ops;
                    targetCount = target;
                    break;
                }
            }
            
            if (minOps == -1) {
                System.out.println(-1);
                continue;
            }
            
            int neededL = targetCount - countL;
            int neededI = targetCount - countI;
            int neededT = targetCount - countT;
            List<Integer> operations = new ArrayList<>();
            StringBuilder result = new StringBuilder(new String(sequence));
            
            for (int i = 0; i < minOps; i++) {
                boolean inserted = false;
                for (int j = 0; j < result.length() - 1; j++) {
                    if (result.charAt(j) == result.charAt(j + 1)) continue;
                    char newChar = getMissingLetter(result.charAt(j), result.charAt(j + 1));
                    if ((newChar == 'L' && neededL > 0) || (newChar == 'I' && neededI > 0) || (newChar == 'T' && neededT > 0)) {
                        operations.add(j + 1);
                        result.insert(j + 1, newChar);
                        if (newChar == 'L') neededL--;
                        else if (newChar == 'I') neededI--;
                        else if (newChar == 'T') neededT--;
                        inserted = true;
                        break;
                    }
                }
                if (!inserted) break;
            }
            
            if (neededL == 0 && neededI == 0 && neededT == 0 && operations.size() == minOps) {
                System.out.println(operations.size());
                operations.forEach(System.out::println);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
