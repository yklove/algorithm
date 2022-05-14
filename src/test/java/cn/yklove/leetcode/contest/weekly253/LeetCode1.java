package cn.yklove.leetcode.contest.weekly253;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : words) {
                stringBuilder.append(word);
                if (stringBuilder.length() > s.length()) {
                    return false;
                }
                if (stringBuilder.toString().equals(s)) {
                    return true;
                }
            }
            return false;
        }
    }

}
