package cn.yklove;


import org.junit.Assert;
import org.junit.Test;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1422 👎 0
public class SingleNumber {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.singleNumber(new int[]{2, 2, 1}), 1);
        Assert.assertEquals(solution.singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int i = 0;
            for (int num : nums) {
                i = i ^ num;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
