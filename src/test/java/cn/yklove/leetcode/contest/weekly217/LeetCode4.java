package cn.yklove.leetcode.contest.weekly217;

import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int maximumWealth(int[][] accounts) {
            int ans = Integer.MIN_VALUE;
            for (int[] account : accounts) {
                int tmp = 0;
                for (int i : account) {
                    tmp += i;
                }
                ans = Math.max(tmp, ans);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {

    }

}
