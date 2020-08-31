package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class Problem4 {

    /**
     * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边 长长度。
     * 例如:
     * 01111
     * 01001
     * 01001
     * 01111
     * 01011 其中边框全是1的最大正方形的大小为4*4，所以返回4。
     */
    class Solution {

        /**
         * 暴力求解过程：
         * ①两个嵌套循环从0~N，枚举正方形的左上角的点(i,j)。
         * ②一个循环从1~N，枚举正方形的边长L。
         * ③检查枚举出的以点(i,j)为左上角，边长为L的正方形，边框是否全为1，至少要两个循环分别检查横着的边和竖着的边。
         * <p>
         * 算法复杂度：O(n^4)
         * 其中③可以优化：
         * 求出两个对应的矩阵，分别表示：
         * 从i,j往下有多少个1；
         * 从i,j往右有多少个1；
         * 这样子第三步就不需要去循环检查了，只需要检查左上角往下的1的个数和右上角往下1的个数，
         * 以及左上角往右1的个数和左下角往右1的个数，是不是等于边长L，如果是的话，这个L是其中的一个答案。
         * 找这两个矩阵的复杂度分别是O(n^2)。查找的复杂度是O(1)。
         * 所以总的复杂度是 2 * O(n^2) + O(n^2) * O(n) * O(1) = O(n^3)
         */
        public int lookingForTheLargestSquare(int[][] matrix) {
            int n = matrix.length;
            int[][] down = new int[n][n];
            int[][] right = new int[n][n];
            // 求down和right数组
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (i == n - 1) {
                        down[i][j] = matrix[i][j];
                        right[j][i] = matrix[j][i];
                        continue;
                    }
                    if (matrix[i][j] == 1) {
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        down[i][j] = matrix[i][j];
                    }
                    if (matrix[j][i] == 1) {
                        right[j][i] = right[j][i + 1] + 1;
                    } else {
                        right[j][i] = matrix[j][i];
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 枚举边长
                    for (int k = 0; i + k < n && j + k < n; k++) {
                        // 判断是否四周都是1
                        if (down[i][j] > k && down[i][j + k] > k
                                && right[i][j] > k && right[i + k][j] > k) {
                            max = Math.max(max, k + 1);
                        }
                    }
                }
            }
            return max;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.lookingForTheLargestSquare(new int[][]{
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        }), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.lookingForTheLargestSquare(new int[][]{{0}}), 0);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.lookingForTheLargestSquare(new int[][]{{1}}), 1);
    }

}
