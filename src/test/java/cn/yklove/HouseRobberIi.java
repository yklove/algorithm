package cn.yklove;


import org.junit.Assert;
import org.junit.Test;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
// 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
// Related Topics 动态规划
// 👍 331 👎 0
public class HouseRobberIi {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.rob(new int[]{2, 3, 2}), 3);
        Assert.assertEquals(solution.rob(new int[]{1, 2, 3, 1}), 4);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rob_1(nums, 0, nums.length - 1), rob_1(nums, 1, nums.length));
        }

        public int rob_1(int[] nums, int start, int end) {
            int x = 0;
            int y = 0;
            for (int i = end - 1; i >= start; i--) {
                int tmpX = x;
                int tmpY = y;
                x = Math.max(tmpX, tmpY);
                y = tmpX + nums[i];
            }
            return Math.max(x, y);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}