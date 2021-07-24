package cn.yklove.leetcode.contest.weekly247;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);

            return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
        }
    }
}
