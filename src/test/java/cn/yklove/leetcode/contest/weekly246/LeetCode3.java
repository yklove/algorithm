package cn.yklove.leetcode.contest.weekly246;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int n = grid1.length;
            int m = grid1[0].length;
            int[][] grid3 = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid3[i][j] = grid1[i][j] + grid2[i][j];
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid2[i][j] != 0 && process(grid2, grid3, i, j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean process(int[][] grid, int[][] grid3, int x, int y) {
            if (x < 0 || y < 0) {
                return true;
            }
            if (x >= grid.length || y >= grid[0].length) {
                return true;
            }
            if (grid[x][y] == 0) {
                return true;
            }
            boolean result = true;
            if (grid3[x][y] != 2) {
                result = false;
            }
            grid[x][y] = 0;
            result &= process(grid, grid3, x - 1, y);
            result &= process(grid, grid3, x + 1, y);
            result &= process(grid, grid3, x, y - 1);
            result &= process(grid, grid3, x, y + 1);
            return result;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.countSubIslands(new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}));
    }

}
