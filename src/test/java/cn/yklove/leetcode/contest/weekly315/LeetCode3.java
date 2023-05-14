package cn.yklove.leetcode.contest.weekly315;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            int start = 0;
            if (num >= 10000) {
                start = 1000;
            } else if (num >= 1000) {
                start = 100;
            } else if (num >= 100) {
                start = 10;
            } else if (num >= 10) {
                start = 0;
            }
            for (int i = start; i <= num; i++) {
                String s = Integer.toString(i);
                String s2 = new StringBuilder(s).reverse().toString();
                int num2 = Integer.parseInt(s2);
                if (num2 + i == num) {
                    return true;
                }
            }
            return false;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.sumOfNumberAndReverse(10));
    }


}
