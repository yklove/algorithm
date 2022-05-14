package cn.yklove.leetcode.contest.weekly255;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {

        int[][] dp;
        int[][] dp2;

        public int minimizeTheDifference(int[][] mat, int target) {
            dp = new int[mat.length + 1][800 * 71 + 1];
            dp2 = new int[mat.length + 1][800 * 71 + 1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
                Arrays.fill(dp2[i], Integer.MIN_VALUE);
            }
            return minDiff(mat, 0, target);
        }

        private int minDiff(int[][] mat, int index, int target) {
            if (target >= 0) {
                if (dp[index][target] != Integer.MIN_VALUE) {
                    return dp[index][target];
                }
            } else {
                if (dp2[index][target * -1] != Integer.MIN_VALUE) {
                    return dp2[index][target * -1];
                }
            }
            if (index == mat.length) {
                int abs = Math.abs(target);
                if (target >= 0) {
                    dp[index][target] = abs;
                } else {
                    dp2[index][target * -1] = abs;
                }
                return abs;
            }
            int min = Integer.MAX_VALUE;
            for (int i : mat[index]) {
                int tmp = minDiff(mat, index + 1, target - i);
                min = Math.min(min, Math.abs(tmp));
            }
            if (target >= 0) {
                dp[index][target] = min;
            } else {
                dp2[index][target * -1] = min;
            }
            return min;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.minimizeTheDifference(new int[][]{
                        {7, 8, 9, 4, 8, 5, 8, 9},
                        {9, 6, 8, 8, 6, 10, 9, 8},
                        {8, 4, 6, 3, 10, 5, 8, 5},
                        {5, 9, 9, 9, 9, 10, 10, 7},
                        {5, 4, 8, 9, 6, 10, 2, 6},
                        {1, 4, 2, 1, 10, 1, 5, 10}}
                , 21);
        Assert.assertEquals(i, 0);
    }

    /**
     * leetcode上通过了，单测没过，原因未知
     */
    @Test
    public void test2() {
        int i = solution.minimizeTheDifference(new int[][]{
                        {18, 49, 33, 11, 40, 27, 15, 39, 17, 3, 44, 2},
                        {38, 31, 7, 3, 35, 3, 18, 41, 30, 37, 38, 23},
                        {33, 18, 8, 31, 8, 49, 36, 45, 13, 21, 34, 37},
                        {35, 28, 42, 38, 6, 7, 35, 6, 3, 32, 36, 7},
                        {39, 7, 50, 23, 11, 33, 15, 31, 5, 21, 29, 25},
                        {40, 16, 39, 3, 16, 29, 30, 34, 12, 45, 28, 13},
                        {3, 38, 32, 30, 7, 25, 44, 8, 43, 16, 18, 15},
                        {30, 18, 20, 18, 32, 16, 46, 36, 20, 28, 30, 16},
                        {19, 28, 37, 35, 25, 29, 50, 27, 37, 46, 17, 43},
                        {42, 36, 41, 33, 3, 41, 35, 17, 48, 41, 35, 27},
                        {14, 44, 17, 15, 41, 34, 28, 37, 32, 46, 42, 37},
                        {41, 2, 17, 27, 3, 26, 5, 30, 38, 24, 11, 30},
                        {44, 19, 25, 8, 4, 25, 36, 35, 45, 4, 43, 6},
                        {10, 16, 17, 16, 11, 34, 44, 31, 41, 40, 29, 10},
                        {37, 25, 46, 5, 14, 16, 1, 40, 18, 28, 20, 12},
                        {24, 25, 39, 31, 39, 47, 4, 19, 13, 35, 42, 46},
                        {13, 8, 34, 20, 19, 19, 19, 8, 38, 39, 45, 37},
                        {44, 42, 9, 25, 16, 12, 37, 41, 4, 38, 17, 32},
                        {14, 7, 20, 7, 39, 18, 4, 46, 33, 10, 32, 16},
                        {2, 41, 24, 23, 22, 30, 28, 18, 28, 1, 8, 5},
                        {14, 39, 46, 49, 7, 28, 18, 32, 31, 13, 30, 42},
                        {3, 21, 23, 18, 14, 41, 1, 18, 28, 36, 47, 20},
                        {47, 32, 41, 12, 18, 6, 48, 14, 4, 9, 24, 48},
                        {31, 37, 50, 11, 33, 32, 40, 9, 13, 17, 13, 30},
                        {42, 9, 35, 24, 50, 48, 5, 25, 37, 3, 44, 21},
                        {45, 31, 29, 4, 25, 17, 36, 41, 4, 39, 40, 24},
                        {16, 30, 32, 13, 11, 33, 28, 14, 20, 1, 18, 20},
                        {49, 39, 10, 39, 19, 30, 37, 2, 7, 16, 50, 2},
                        {14, 39, 12, 4, 28, 15, 22, 30, 15, 39, 18, 3},
                        {2, 32, 24, 34, 1, 39, 28, 20, 1, 22, 31, 2},
                        {1, 34, 43, 8, 24, 7, 9, 34, 32, 29, 50, 39},
                        {45, 24, 29, 23, 43, 44, 4, 26, 1, 49, 3, 28},
                        {29, 9, 6, 40, 2, 37, 49, 25, 13, 9, 43, 9},
                        {37, 40, 14, 9, 19, 36, 47, 4, 7, 30, 15, 25},
                        {44, 17, 9, 37, 14, 34, 31, 22, 38, 28, 14, 12},
                        {2, 28, 22, 26, 29, 26, 28, 32, 22, 27, 15, 35},
                        {37, 39, 10, 29, 26, 47, 32, 26, 9, 38, 48, 40}}
                , 191);
        Assert.assertEquals(i, 59);
    }


}
