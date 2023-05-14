package cn.yklove.leetcode.contest.weekly305;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode1 {
    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int ans = 0;
            for (int i = 2; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (nums[i] - nums[j] == diff && nums[j] - nums[k] == diff) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertEquals(2,solution.arithmeticTriplets(new int[]{4,5,6,7,8,9},2));
    }
}
