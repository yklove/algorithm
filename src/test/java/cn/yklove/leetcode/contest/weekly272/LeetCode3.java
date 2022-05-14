package cn.yklove.leetcode.contest.weekly272;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public long getDescentPeriods(int[] prices) {
            long ans = prices.length;
            if (prices.length < 2) {
                return ans;
            }
            int count = 1;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] == -1) {
                    count++;
                } else {
                    // 计算下
                    if (count != 1) {
                        for (int j = 1; j < count; j++) {
                            ans += j;
                        }
                    }
                    count = 1;
                }
            }
            // 计算下
            if (count != 1) {
                for (int j = 1; j < count; j++) {
                    ans += j;
                }
            }
            return ans;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertEquals(7,solution.getDescentPeriods(new int[]{3,2,1,4}));
    }

}
