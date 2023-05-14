package cn.yklove.leetcode.contest.weekly304;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int minimumOperations(int[] nums) {
            int ans = 0;
            boolean isTrue = true;
            for (int num : nums) {
                if (num != 0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                return ans;
            }
            while (true) {
                int min = Integer.MAX_VALUE;
                for (int num : nums) {
                    if (num == 0) {
                        continue;
                    }
                    min = Math.min(min, num);
                }
                ans++;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        continue;
                    }
                    nums[i] = nums[i] - min;
                }
                isTrue = true;
                for (int num : nums) {
                    if (num != 0) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) {
                    return ans;
                }
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
}
