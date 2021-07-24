package cn.yklove.leetcode.contest.weekly249;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {


    class Solution {
        public int countPalindromicSubsequence(String s) {
            int ans = 0;
            char[] chars = s.toCharArray();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < chars.length - 2; i++) {
                for (int j = i + 1; j < chars.length - 1; j++) {
                    for (int k = j + 1; k < chars.length; k++) {
                        if (chars[i] == chars[k]) {
                            String s1 = new String(new char[]{chars[i], chars[j], chars[k]});
                            if (!set.contains(s1)) {
                                ans++;
                                set.add(s1);
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}
