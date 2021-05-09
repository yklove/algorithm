package cn.yklove.leetcode.contest.weekly240;

import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int maximumPopulation(int[][] logs) {
            int[][] ints = new int[101][101];
            for (int i = 0; i < logs.length; i++) {
                int[] log = logs[i];
                int start = log[0];
                int end = log[1];
                for (int j = start; j < end; j++) {
                    ints[j - 1950][i] = 1;
                }
            }
            int maxSum = 0;
            int ans = 1950;
            // 对年份进行遍历
            for (int i = 0; i < ints.length; i++) {
                int sum = 0;
                for (int j : ints[i]) {
                    sum += j;
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    ans = 1950 + i;
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        solution.maximumPopulation(new int[][]{{1993,1999},{2000,2010}});
    }
}
