package cn.yklove.leetcode.contest.weekly289;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int maxTrailingZeros(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            Node[][] nodes = new Node[m][n];
            for (int i = 0; i < m - 1; i++) {
                // 以 grid[i][0] 为起点
                for (int j = i + 1; j < m; j++) {
                    for (int k = 1; k < n; k++) {
                        // 以 grid[j][k] 为终点

                    }
                }
            }
            for (int j = 1; j < n - 1; j++) {
                // 以 grid[0][j] 为起点
            }
            return 0;
        }

        class Node {
            int twoCount;
            int fiveCount;

            public Node(int twoCount, int fiveCount) {
                this.twoCount = twoCount;
                this.fiveCount = fiveCount;
            }
        }
    }

}
