package cn.yklove.leetcode.contest.weekly271;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public long subArrayRanges(int[] nums) {
            if (nums.length <= 1) {
                return 0L;
            }
            long ans = 0L;
            int max;
            int min;
            for (int i = 0; i < nums.length - 1; i++) {
                max = nums[i];
                min = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    ans += (max - min);
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertEquals(59,solution.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }


}
