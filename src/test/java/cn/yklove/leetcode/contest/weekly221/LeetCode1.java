package cn.yklove.leetcode.contest.weekly221;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {

        private Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        public boolean halvesAreAlike(String s) {
            int countA = 0;
            int countB = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    if (i < chars.length / 2) {
                        countA++;
                    } else {
                        countB++;
                    }
                }
            }
            return countA == countB;
        }
    }


}
