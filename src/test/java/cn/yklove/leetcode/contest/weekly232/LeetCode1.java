package cn.yklove.leetcode.contest.weekly232;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            char[] s1Chars = s1.toCharArray();
            char[] s2Chars = s2.toCharArray();
            int count = 0;
            char x = 0, y = 0;
            char z = 0, k = 0;
            for (int i = 0; i < s1Chars.length; i++) {
                if (s1Chars[i] != s2Chars[i]) {
                    count++;
                    if (count == 1) {
                        x = s1Chars[i];
                        y = s2Chars[i];
                    } else if (count == 2) {
                        z = s1Chars[i];
                        k = s2Chars[i];
                    }
                }
                if (count > 2) {
                    return false;
                }
            }
            return x == k && y == z;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertTrue(solution.areAlmostEqual("bank","kanb"));
    }

}
