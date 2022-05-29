package cn.yklove.leetcode.contest.weekly293;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int largestCombination(int[] candidates) {
            int[] dp = new int[33];
            for (int candidate : candidates) {
                int index = 0;
                while (candidate != 0) {
                    if ((candidate & 1) == 1) {
                        dp[index]++;
                    }
                    candidate = candidate >> 1;
                    index++;
                }
            }
            int ans = 0;
            for (int i : dp) {
                ans = Math.max(i, ans);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.largestCombination(new int[]{10, 72, 58, 33, 36, 70, 12, 88, 9, 48, 78, 97, 87, 19, 78, 9, 47, 73}), 11);
    }
}
