package cn.yklove.offer;

import org.junit.Assert;
import org.junit.Test;

public class Problem56_2 {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。<br/>
     * 请找出那个只出现一次的数字。
     * <p>
     * 1 <= nums.length <= 10000 </br>
     * 1 <= nums[i] < 2^31
     */
    class Solution {
        /**
         * 考虑数字的二进制形式，对于出现三次的数字，各二进制位出现的次数都是 3 的倍数。</br>
         * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
         */
        public int singleNumber(int[] nums) {
            int[] count = new int[31];
            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[i];
                char[] binary = Integer.toBinaryString(tmp).toCharArray();
                for (int j = binary.length - 1; j >= 0; j--) {
                    count[binary.length - 1 - j] += binary[j];
                }
            }
            int ans = 0;
            for (int i = 0; i < count.length; i++) {
                ans = ans + (count[i] % 3 == 0 ? 0 : (int) Math.pow(2.0, i));
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.singleNumber(new int[] { 3, 4, 3, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, solution.singleNumber(new int[] { 9, 1, 7, 9, 7, 9, 7 }));
    }

}