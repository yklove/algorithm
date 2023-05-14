package cn.yklove.leetcode.contest.weekly306;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int[][] ans = new int[grid.length - 2][grid.length - 2];
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid.length - 1; j++) {
                    ans[i - 1][j - 1] = max(grid, i, j);
                }
            }
            return ans;
        }

        private int max(int[][] grid, int i, int j) {
            int ans = grid[i][j];
            ans = Math.max(ans, grid[i - 1][j - 1]);
            ans = Math.max(ans, grid[i - 1][j]);
            ans = Math.max(ans, grid[i - 1][j + 1]);
            ans = Math.max(ans, grid[i][j - 1]);
            ans = Math.max(ans, grid[i][j + 1]);
            ans = Math.max(ans, grid[i + 1][j - 1]);
            ans = Math.max(ans, grid[i + 1][j]);
            ans = Math.max(ans, grid[i + 1][j + 1]);
            return ans;
        }
    }

}
