package cn.yklove.leetcode.contest.weekly244;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            if (arrEquals(mat, target)) {
                return true;
            }
            for (int i = 0; i < 3; i++) {
                rotate(mat);
                if (arrEquals(mat, target)) {
                    return true;
                }
            }
            return false;
        }

        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix_new[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                System.arraycopy(matrix_new[i], 0, matrix[i], 0, n);
            }
        }

        private boolean arrEquals(int[][] mat, int[][] target) {
            for (int i = 0; i < mat.length; i++) {
                int[] arr = mat[i];
                int[] arrTarget = target[i];
                if (!Arrays.equals(arr, arrTarget)) {
                    return false;
                }
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));
    }
}
