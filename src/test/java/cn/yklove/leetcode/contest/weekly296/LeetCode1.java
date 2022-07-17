package cn.yklove.leetcode.contest.weekly296;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int minMaxGame(int[] nums) {
            while (nums.length != 1) {
                int[] newNums = new int[nums.length / 2];
                for (int i = 0; i < newNums.length; i++) {
                    if (i % 2 == 0) {
                        newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    }else{
                        newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                    }
                }
                nums = newNums;
            }
            return nums[0];
        }
    }

}
