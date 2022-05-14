package cn.yklove.leetcode.contest.weekly285;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {

        private int[] dp;

        public int countCollisions(String directions) {
            char[] chars = directions.toCharArray();
            dp = new int[chars.length + 1];
            Arrays.fill(dp, -1);
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                ans += mobile(chars, i);
            }
            return ans;
        }

        private int mobile(char[] chars, int index) {
            if (dp[index] != -1) {
                return dp[index];
            }
            char c = chars[index];
            if (c == 'S') {
                dp[index] = 0;
                return 0;
            }
            if (c == 'L') {
                if (index == 0) {
                    dp[index] = 0;
                    return 0;
                }
                if (chars[index - 1] == 'S' || chars[index - 1] == 'R') {
                    dp[index] = 1;
                    return 1;
                }
                if (mobile(chars, index - 1) != 0) {
                    dp[index] = 1;
                    return 1;
                }
                dp[index] = 0;
                return 0;
            }
            if (c == 'R') {
                if (index == chars.length - 1) {
                    dp[index] = 0;
                    return 0;
                }
                if (chars[index + 1] == 'S' || chars[index + 1] == 'L') {
                    dp[index] = 1;
                    return 1;
                }
                if (mobile(chars, index + 1) != 0) {
                    dp[index] = 1;
                    return 1;
                }
                dp[index] = 0;
                return 0;
            }
            dp[index] = 0;
            return 0;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.countCollisions("RLRSLL");
    }

}
