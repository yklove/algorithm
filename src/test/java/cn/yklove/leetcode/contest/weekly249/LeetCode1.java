package cn.yklove.leetcode.contest.weekly249;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int[] getConcatenation(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n * 2];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i];
                ans[i + n] = nums[i];
            }
            return ans;
        }
    }


}
