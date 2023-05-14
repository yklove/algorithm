package cn.yklove.leetcode.contest.weekly305;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode3 {
    class Solution {

        int[] dpA;
        int[][] dpB;

        public boolean validPartition(int[] nums) {
            dpA = new int[nums.length + 1];
            dpB = new int[nums.length + 1][4];
            return process(nums, 0);
        }

        private boolean process(int[] nums, int start) {
            if (dpA[start] != 0) {
                return dpA[start] == 1;
            }
            if (start >= nums.length) {
                dpA[start] = 1;
                return true;
            }
            for (int i = 1; i <= 2; i++) {
                if (doProcess(nums, start, start + i)) {
                    dpA[start] = 1;
                    return true;
                }
            }
            dpA[start] = 2;
            return false;
        }

        private boolean doProcess(int[] nums, int start, int end) {
            if (dpB[start][end - start] != 0) {
                return dpB[start][end - start] == 1;
            }
            if (end >= nums.length) {
                dpB[start][end - start] = 2;
                return false;
            }
            if (end - start == 1) {
                if (nums[start] == nums[end]) {
                    boolean process = process(nums, end + 1);
                    if (process) {
                        dpB[start][end - start] = 1;
                    } else {
                        dpB[start][end - start] = 2;
                    }
                    return process;
                }
            } else {
                if (nums[start] == nums[start + 1] && nums[start + 1] == nums[end]) {
                    boolean process = process(nums, end + 1);
                    if (process) {
                        dpB[start][end - start] = 1;
                    } else {
                        dpB[start][end - start] = 2;
                    }
                    return process;
                }
                if (nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[end]) {
                    boolean process = process(nums, end + 1);
                    if (process) {
                        dpB[start][end - start] = 1;
                    } else {
                        dpB[start][end - start] = 2;
                    }
                    return process;
                }
            }
            dpB[start][end - start] = 2;
            return false;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        boolean b = solution.validPartition(new int[]{4, 4, 4, 5, 6});
        System.out.println(b);
    }
}
