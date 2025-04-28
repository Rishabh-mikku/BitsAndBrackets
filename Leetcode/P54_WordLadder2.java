import java.util.*;
public class P54_WordLadder2 {
    public static void main(String[] args) {
        try {
            String beginWord = "hit", endWord = "cog";
            // String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
            String[] wordList = {"hot", "dot", "dog", "lot", "log"};
            int n = wordList.length;

            Set<String> st = new HashSet<>();
            for (int i=0;i<n;i++) {
                st.add(wordList[i]);
            }
            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> ls = new ArrayList<>();
            ls.add(beginWord);
            q.add(ls);
            ArrayList<String> usedOnLevel = new ArrayList<>();
            usedOnLevel.add(beginWord);
            int level = 0;
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                ArrayList<String> v = q.poll();
                if (v.size() > level) {
                    level++;
                    for (String it : usedOnLevel) {
                        st.remove(it);
                    }
                }
                String lastWord = v.get(v.size() - 1);
                if (lastWord.equals(endWord)) {
                    if (ans.size() == 0) {
                        ans.add(v);
                    }
                    else if (ans.get(0).size() == v.size()) {
                        ans.add(v);
                    }
                }
                for (int i=0;i<lastWord.length();i++) {
                    for (char ch='a';ch<='z';ch++) {
                        char[] replacedArray = lastWord.toCharArray();
                        replacedArray[i] = ch;
                        String replacedWord = new String(replacedArray);
                        if (st.contains(replacedWord)) {
                            v.add(replacedWord);
                            ArrayList<String> temp = new ArrayList<>(v);
                            q.add(temp);
                            usedOnLevel.add(replacedWord);
                            v.remove(v.size()-1);
                        }
                    }
                }
            }

            for (int i=0;i<ans.size();i++) {
                for (int j=0;j<ans.get(i).size();j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
