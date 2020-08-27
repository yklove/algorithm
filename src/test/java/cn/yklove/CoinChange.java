package cn.yklove;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划
// 👍 724 👎 0
public class CoinChange {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.coinChange(new int[]{1, 2, 5}, 11), 3);
        Assert.assertEquals(solution.coinChange(new int[]{470, 18, 66, 301, 403, 112, 360}, 8235), 20);
        Assert.assertEquals(solution.coinChange(new int[]{186, 419, 83, 408}, 6249), 20);
        Assert.assertEquals(solution.coinChange(new int[]{3}, 2), -1);
        Assert.assertEquals(solution.coinChange(new int[]{3}, 3), 1);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < coins.length + 1; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][0] = 0;
            }
            for (int i = coins.length - 1; i >= 0; i--) {
                for (int j = 1; j <= amount; j++) {
                    int maxCount = j / coins[i];
                    for (int k = 0; k <= maxCount; k++) {
                        if (dp[i + 1][j - k * coins[i]] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], k + dp[i + 1][j - k * coins[i]]);
                        }
                    }
                }
            }
            return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
