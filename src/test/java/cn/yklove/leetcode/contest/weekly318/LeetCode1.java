package cn.yklove.leetcode.contest.weekly318;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int[] applyOperations(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i+1] = 0;
                }
            }
            int[] ans = new int[nums.length];
            int end = nums.length - 1;
            int start = 0;
            for (int num : nums) {
                if (num != 0) {
                    ans[start] = num;
                    start++;
                } else {
                    ans[end] = 0;
                    end--;
                }
            }
            return ans;
        }
    }

}
