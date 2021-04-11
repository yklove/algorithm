package cn.yklove.nowcoder.course2;

import org.junit.Assert;
import org.junit.Test;

public class Problem1 {

    /**
     * 给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
     */
    class Solution {

        /**
         * 假设有n个节点，那么能形成的不同结构的二叉树的数量是：
         * <p>
         * 左侧是0个节点的结果 * 右侧是 n-1 个节点的结果
         * <p/>
         * + 左侧是1个节点的结果 * 右侧是 n-2 个节点的结果
         * <p/>
         * + ……
         * <p/>
         *
         * @param n
         * @return
         */
        public int theNumberOfDifferentStructures(int n) {
            if (n == 0) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // i 代表当前的节点个数
            for (int i = 2; i <= n; i++) {
                // j 代表左侧节点的个数
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.theNumberOfDifferentStructures(1), 1);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.theNumberOfDifferentStructures(0), 1);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.theNumberOfDifferentStructures(2), 2);
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.theNumberOfDifferentStructures(3), 5);
    }
}