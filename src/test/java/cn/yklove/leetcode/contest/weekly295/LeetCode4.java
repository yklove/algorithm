package cn.yklove.leetcode.contest.weekly295;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        class Info {
            int x;
            int y;

            public Info(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int minimumObstacles(int[][] grid) {
            int[][] count = new int[grid.length][grid[0].length];
            for (int[] ints : count) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            count[0][0] = 0;
            Queue<Info> queue = new LinkedList<>();
            queue.add(new Info(0, 0));
            processInitial(grid, count, queue);
            if (count[grid.length - 1][grid[0].length - 1] == 0) {
                return 0;
            }
            while (!queue.isEmpty()) {
                Info poll = queue.poll();
                int i = count[poll.x][poll.y];
                process(grid, count, poll.x, poll.y - 1, queue, i);
                process(grid, count, poll.x, poll.y + 1, queue, i);
                process(grid, count, poll.x - 1, poll.y, queue, i);
                process(grid, count, poll.x + 1, poll.y, queue, i);
            }
            return count[grid.length - 1][grid[0].length - 1];
        }

        private void process(int[][] grid, int[][] count, int i, int j, Queue<Info> queue, int min) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (count[i][j] == 0) {
                return;
            }

            if (min + (grid[i][j] == 1 ? 1 : 0) < count[i][j]) {
                queue.add(new Info(i, j));
                count[i][j] = min + (grid[i][j] == 1 ? 1 : 0);
            }
        }

        private void processInitial(int[][] grid, int[][] count, Queue<Info> queue) {
            doProcessInitial(grid, count, 0, 1, queue);
            doProcessInitial(grid, count, 1, 0, queue);
        }

        private void doProcessInitial(int[][] grid, int[][] count, int i, int j, Queue<Info> queue) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 0) {
                queue.add(new Info(i, j));
                count[i][j] = 0;
                grid[i][j] = -1;
                doProcessInitial(grid, count, i, j - 1, queue);
                doProcessInitial(grid, count, i, j + 1, queue);
                doProcessInitial(grid, count, i - 1, j, queue);
                doProcessInitial(grid, count, i + 1, j, queue);
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.minimumObstacles(new int[][]{
                {0, 1, 1}, {1, 1, 0}, {1, 1, 0}
        }));
    }

    @Test
    public void test2() {
        solution.minimumObstacles(new int[][]{
                {0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}
        });
    }

}
