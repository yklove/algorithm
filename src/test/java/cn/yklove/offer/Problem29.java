package cn.yklove.offer;

import org.junit.Assert;
import org.junit.Test;

public class Problem29 {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int n = matrix.length;
            int m = matrix[0].length;
            int[] ans = new int[n * m];
            int count = 0;
            int i = 0;
            int j = 0;
            int x1 = 0;
            int y1 = m;
            int x2 = 0;
            int y2 = n;
            // 0-右 1-左 2-下 3-上
            int direction = 0;
            while (count != n * m) {
                ans[count] = matrix[i][j];
                if (direction == 0) {
                    j++;
                    if (j == y1) {
                        x2++;
                        j--;
                        i++;
                        direction = 2;
                    }
                } else if (direction == 1) {
                    j--;
                    if (j < x1) {
                        y2--;
                        j++;
                        i--;
                        direction = 3;
                    }
                } else if (direction == 2) {
                    i++;
                    if (i == y2) {
                        y1--;
                        i--;
                        j--;
                        direction = 1;
                    }
                } else if (direction == 3) {
                    i--;
                    if (i < x2) {
                        x1++;
                        i++;
                        j++;
                        direction = 0;
                    }
                }
                count++;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertArrayEquals(solution.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }),
                new int[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 });
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(solution.spiralOrder(new int[][] { { 1 } }), new int[] { 1 });
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(
                solution.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }),
                new int[] { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 });
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(solution.spiralOrder(new int[][] {}), new int[] {});
    }
}