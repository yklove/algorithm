package cn.yklove.leetcode.contest.weekly324;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int[] cycleLengthQueries(int n, int[][] queries) {
            int[] ans = new int[queries.length];
            int[] vec = new int[(int) Math.pow(2, n) - 1];
            for (int i = 0; i < vec.length; i++) {
                vec[i] = i + 1;
            }
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0];
                int b = queries[i][1];
                int x = (int) (Math.log(a) / Math.log(2));
                int y = (int) (Math.log(b) / Math.log(2));
                dfsans = -1;
                dfs(vec, 0, a - 1, b - 1);
                dfsans = dfsans + 1;
                if (dfsans == -1) {
                    ans[i] = (x) + (y) + 1;
                } else if (dfsans == a) {
                    ans[i] = y - x + 1;
                } else if (dfsans == b) {
                    ans[i] = x - y + 1;
                } else {
                    int z = (int) (Math.log(dfsans) / Math.log(2));
                    ans[i] = x - z + y - z + 1;
                }
            }
            return ans;
        }

        private int[][] map;

        private int dfsans;

        private boolean dfs(int[] vec, int root, int p, int q) {
            if (root >= vec.length) return false;
            boolean lson = dfs(vec, root * 2 + 1, p, q);
            boolean rson = dfs(vec, root * 2 + 2, p, q);
            if ((lson && rson) || ((vec[root] == vec[p] || vec[root] == vec[q]) && (lson || rson))) {
                dfsans = root;
            }
            return lson || rson || (vec[root] == vec[p] || vec[root] == vec[q]);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{4, 5, 3}, solution.cycleLengthQueries(3, new int[][]{
                {5, 3},
                {4, 7},
                {2, 3},
        }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{2}, solution.cycleLengthQueries(2, new int[][]{
                {1, 2}
        }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{7, 3, 2, 6, 8, 6, 3, 7}, solution.cycleLengthQueries(5, new int[][]{
                {17, 21}, {23, 5}, {15, 7}, {3, 21}, {31, 9}, {5, 15}, {11, 2}, {19, 7}
        }));
    }

}
