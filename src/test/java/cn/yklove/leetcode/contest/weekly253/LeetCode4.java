package cn.yklove.leetcode.contest.weekly253;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int[] dp = new int[obstacles.length];
            for (int i = 0; i < obstacles.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (obstacles[i] >= obstacles[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3}, solution.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 2, 3, 4, 5, 3, 5}, solution.longestObstacleCourseAtEachPosition(new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4}));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 2, 2}, solution.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2}));
    }

}
