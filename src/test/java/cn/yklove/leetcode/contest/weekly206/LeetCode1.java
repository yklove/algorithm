package cn.yklove.leetcode.contest.weekly206;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int numSpecial(int[][] mat) {
            int[] rows = new int[mat.length];

            int[] cols = new int[mat[0].length];

            for (int i = 0; i < mat.length; i++) {
                int count = 0;
                for (int j = 0; j < mat[i].length; j++) {
                    count += mat[i][j];
                }
                rows[i] = count;
            }

            for (int i = 0; i < mat[0].length; i++) {
                int count = 0;
                for (int[] ints : mat) {
                    count += ints[i];
                }
                cols[i] = count;
            }
            int ans = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (rows[i] == 1 && cols[j] == 1 && mat[i][j] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.numSpecial(new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        }));
    }
}
