package leetcode.algorithm.p3;

import java.util.HashSet;
import java.util.Set;

/**
 * p3: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author xinquan.huangxq
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length == 0 || length == 1) {
            return length;
        }
        int result = 0;
        Set<Character> sets = new HashSet<Character>();
        for (int i = 0; i < s.length() - 1; ++i) {
            sets.add(s.charAt(i));
            int j;
            for (j = i + 1; j < s.length(); ++j) {
                if (sets.contains(s.charAt(j))) {
                    if (result < sets.size()) {
                        result = sets.size();
                    }
                    sets.clear();
                    break;
                } else {
                    sets.add(s.charAt(j));
                }
            }
            if (j == s.length()) {
                if (result < sets.size()) {
                    result = sets.size();
                }
                sets.clear();
            }

        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length == 0 || length == 1) {
            return length;
        }
        int i = 0, j = 0, result = 0;
        Set<Character> sets = new HashSet<>();
        while (i < length && j < length) {
            if (sets.contains(s.charAt(j))) {
                if (result < (j - i)) {
                    result = j - i;
                }
                sets.remove(s.charAt(i++));
            } else {
                sets.add(s.charAt(j++));
            }
        }
        if (result < (j - i)) {
            result = j - i;
        }
        return result;
    }
}
