package cn.yklove.leetcode.contest.biweekly54;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            boolean[] arr = new boolean[51];
            for (int[] range : ranges) {
                Arrays.fill(arr, range[0], range[1] + 1, true);
            }
            for (int i = left; i <= right; i++) {
                if (!arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
