package cn.yklove.leetcode.contest.weekly255;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int findGCD(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            for (int i = Math.min(min, max); i >= 1; i--) {
                if (max % i == 0 && (min % i) == 0) {
                    return i;
                }
            }
            return 1;
        }
    }

}
