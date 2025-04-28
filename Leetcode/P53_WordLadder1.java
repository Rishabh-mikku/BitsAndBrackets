import java.util.*;
public class P53_WordLadder1 {
    static class Pair {
        String word;
        int steps;
        Pair (String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {
        try {
            String beginWord = "hit", endWord = "cog";
            // String[] wordList = new String[]{"hot", "dog", "lot", "log", "cog", "dot"};
            String[] wordList = {"hot", "dog", "dot", "lot", "log"};
            int n = wordList.length;

            Queue<Pair> q = new LinkedList<>();
            Set<String> st = new HashSet<>();
            for (int i=0;i<n;i++) {
                st.add(wordList[i]);
            }
            q.add(new Pair(beginWord, 1));
            st.remove(beginWord);

            while (!q.isEmpty()) {
                Pair  p = q.poll();
                String word = p.word;
                int steps = p.steps;
                if (word.equalsIgnoreCase(endWord)) {
                    System.out.println(steps);
                    return;
                }
                for (int i=0;i<word.length();i++) {
                    for (char ch='a';ch<='z';ch++) {
                        char[] replacedArray = word.toCharArray();
                        replacedArray[i] = ch;
                        String replacedWord = new String(replacedArray);
                        if (st.contains(replacedWord)) {
                            st.remove(replacedWord);
                            q.add(new Pair(replacedWord, steps+1));
                        }
                    }
                }
            }
            System.out.println(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
