/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (set.add(ch)) {
                maxLength  =Math.max(maxLength, r-l+1);
                r++;
            } else {
                while (s.charAt(l) != ch) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(ch);
                l++;
            }
        }
        return maxLength;
    }
}
// @lc code=end

