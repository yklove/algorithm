package cn.yklove.leetcode.contest.weekly246;

import org.junit.Assert;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public String largestOddNumber(String num) {
            char[] chars = num.toCharArray();
            int index = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if ((chars[i] - '0') % 2 != 0) {
                    index = i;
                    break;
                }
            }
            return num.substring(0, index);
        }
    }

    Solution solution = new Solution();

    public void test(){
        Assert.assertEquals("5",solution.largestOddNumber("52"));
    }
}
