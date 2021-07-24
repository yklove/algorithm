package cn.yklove.leetcode.contest.biweekly54;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {

        public int chalkReplacer(int[] chalk, int k) {
            long sum = 0;
            for (int i : chalk) {
                sum += i;
            }
            long tmp = k % sum;
            int ans = 0;
            while (tmp > 0) {
                tmp -= chalk[ans];
                if (tmp < 0) {
                    return ans;
                }
                ans++;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.chalkReplacer(new int[]{3, 4, 1, 2}, 25));
    }

}
