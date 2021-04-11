package cn.yklove.leetcode.contest.weekly236;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int arraySign(int[] nums) {
            boolean flag = true;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                } else if (num < 0) {
                    flag = !flag;
                }
            }
            if (flag) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
