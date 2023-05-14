package cn.yklove.leetcode.contest.weekly316;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public long minCost(int[] nums, int[] cost) {
            byte[] set = new byte[1000001];
            long min = Long.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (set[i] == 1) {
                    continue;
                }
                set[i] = 1;
                long tmp = 0;
                for (int j = 0; j < nums.length; j++) {
                    long diff = nums[j] - nums[i];
                    if (diff < 0) {
                        diff *= -1;
                    }
                    tmp += (diff * cost[j]);
                }
                min = Math.min(min, tmp);
            }
            return min;
        }
    }

}
