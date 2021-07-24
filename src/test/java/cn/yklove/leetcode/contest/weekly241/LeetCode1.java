package cn.yklove.leetcode.contest.weekly241;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {

        private int ansSum = 0;

        public int subsetXORSum(int[] nums) {
            ansSum = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    process(nums, nums[i], i + 1, j);
                }
            }
            return ansSum;
        }

        private void process(int[] nums, int sum, int index, int count) {
            if (count == 0) {
                ansSum += sum;
                return;
            }
            if (index >= nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                process(nums, sum ^ nums[i], i + 1, count - 1);
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.subsetXORSum(new int[]{5, 1, 6}), 28);

    }


}
