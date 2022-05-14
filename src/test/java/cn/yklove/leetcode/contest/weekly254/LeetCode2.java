package cn.yklove.leetcode.contest.weekly254;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            Arrays.sort(nums);
            int[] tmp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                tmp[nums.length - i - 1] = nums[i];
            }
            int[] ans = new int[nums.length];
            boolean key = true;
            int indexX = 0;
            int indexY = 0;
            for (int i = 0; i < nums.length; i++) {
                if (key) {
                    ans[i] = nums[indexX++];
                } else {
                    ans[i] = tmp[indexY++];
                }
                key = !key;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.rearrangeArray(new int[]{1, 5, 2, 6, 3, 7, 4, 8});
//        solution.rearrangeArray(new int[]{1, 2, 3});
    }

}
