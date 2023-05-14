package cn.yklove.leetcode.contest.weekly322;

import java.util.Objects;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] s = sentence.split(" ");
            for (int i = 0; i < s.length - 1; i++) {
                if (!s[i].substring(s[i].length() - 1)
                        .equals(s[i + 1].substring(0, 1))) {
                    return false;
                }
            }
            if (!s[s.length - 1].substring(s[s.length - 1].length() - 1).equals(
                    s[0].substring(0, 1)
            )) {
                return false;
            }
            return true;
        }
    }

}
