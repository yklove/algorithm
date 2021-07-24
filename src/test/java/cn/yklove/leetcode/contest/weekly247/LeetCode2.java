package cn.yklove.leetcode.contest.weekly247;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            // 层数遍历
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                // 没有层数了
                if (m - i * 2 <= 0 || n - i * 2 <= 0) {
                    break;
                }
                int count = (m - i * 2) * 2 + (n - i * 2) * 2 - 4;
                int tmpK = k % count;
                // 逆转tmpK次
                for (int p = 0; p < tmpK; p++) {
                    int x = i;
                    int y = i;
                    int current = grid[x][y];
                    for (int j = 0; j < (m - i * 2) - 1; j++) {
                        x++;
                        int tmp = grid[x][y];
                        grid[x][y] = current;
                        current = tmp;
                    }
                    for (int j = 0; j < (n - i * 2) - 1; j++) {
                        y++;
                        int tmp = grid[x][y];
                        grid[x][y] = current;
                        current = tmp;
                    }
                    for (int j = 0; j < (m - i * 2) - 1; j++) {
                        x--;
                        int tmp = grid[x][y];
                        grid[x][y] = current;
                        current = tmp;
                    }
                    for (int j = 0; j < (n - i * 2) - 1; j++) {
                        y--;
                        int tmp = grid[x][y];
                        grid[x][y] = current;
                        current = tmp;
                    }
                }
            }
            return grid;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{
                {10, 20}, {40, 30}
        }, solution.rotateGrid(new int[][]{{40, 10}, {30, 20}}, 1));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][]{
                {4,5,1,4,5,3,9,1,9,5,2,2,4,2,8,9},
                {8,1,9,4,6,2,1,9,7,7,1,5,6,8,7,1},
                {7,1,1,7,1,1,1,1,7,1,3,4,1,7,1,1},
                {7,7,8,7,5,5,8,5,3,4,6,6,7,1,6,9},
                {1,8,8,7,2,6,1,2,2,5,7,7,9,6,1,6},
                {9,1,9,9,8,1,9,7,3,4,8,1,6,4,7,2},
                {2,3,9,5,6,3,6,6,9,7,4,4,4,6,1,3},
                {7,3,9,2,7,5,1,8,8,6,6,9,3,9,2,8},
                {1,4,9,4,7,4,9,5,7,9,3,9,3,1,6,6},
                {2,1,1,1,4,3,4,1,1,7,2,9,1,3,2,4}
        }, solution.rotateGrid(new int[][]{{9,1,7,7,8,4,5,1,4,5,3,9,1,9,5,2},
                {2,3,1,8,7,1,1,9,4,6,2,1,9,7,7,2},
                {7,3,9,9,9,8,8,1,7,1,1,1,1,7,1,4},
                {1,4,2,3,6,5,9,7,7,5,5,8,5,1,5,2},
                {2,9,7,6,3,7,9,1,8,2,6,1,3,3,6,8},
                {1,4,5,6,4,8,1,7,7,5,2,2,4,4,8,9},
                {1,7,1,9,7,4,4,4,6,9,7,6,6,1,7,1},
                {1,4,8,8,6,6,9,3,9,6,4,6,1,7,1,1},
                {4,9,5,7,9,3,9,3,1,6,2,1,7,1,6,9},
                {3,4,1,1,7,2,9,1,3,2,4,6,8,3,2,6}}, 5));
    }
}
