package cn.yklove.leetcode.contest.weekly236;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.minSideJumps(new int[]{0, 1, 2, 3, 0}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, solution.minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, solution.minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
    }

    class Solution {

        private int[][] dp;

        public int minSideJumps(int[] obstacles) {
            dp = new int[obstacles.length + 1][4];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            return process(0, 2, obstacles);
        }

        public int process(int x, int y, int[] obstacles) {
            if (dp[x][y] != -1) {
                return dp[x][y];
            }
            if (x == obstacles.length - 1) {
                dp[x][y] = 0;
                return 0;
            }
            if (obstacles[x + 1] != y) {
                int process = process(x + 1, y, obstacles);
                dp[x][y] = process;
                return process;
            }
            // 另外两条路上走
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (i != y && obstacles[x] != i) {
                    int tmp = 1 + process(x, i, obstacles);
                    ans = Math.min(tmp, ans);
                }
            }
            dp[x][y] = ans;
            return ans;
        }
    }

}
