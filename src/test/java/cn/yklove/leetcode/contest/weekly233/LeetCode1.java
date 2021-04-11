package cn.yklove.leetcode.contest.weekly233;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int maxAscendingSum(int[] nums) {
            int maxSum = nums[0];
            int tmpSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    tmpSum += nums[i];
                    maxSum = Math.max(maxSum, tmpSum);
                } else {
                    tmpSum = nums[i];
                }
            }
            return maxSum;
        }
    }

}
