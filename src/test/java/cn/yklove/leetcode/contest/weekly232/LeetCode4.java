package cn.yklove.leetcode.contest.weekly232;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int maximumScore(int[] nums, int k) {
            int min = nums[k];
            int i = k;
            int j = k;
            int ans = min;
            while (i > 0 || j < nums.length - 1) {
                // 尝试向右扩展
                for (int tmp = j + 1; tmp < nums.length; tmp++) {
                    if (nums[tmp] >= min) {
                        j++;
                    } else {
                        break;
                    }
                }
                // 尝试向左扩展
                for (int tmp = i - 1; tmp >= 0; tmp--) {
                    if (nums[tmp] >= min) {
                        i--;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, (j - i + 1) * min);
                int tmpRight = min;
                if (j < nums.length - 1) {
                    tmpRight = Math.min(min, nums[j + 1]);
                } else {
                    tmpRight = 0;
                }
                int tmpLeft = min;
                if (i > 0) {
                    tmpLeft = Math.min(min, nums[i - 1]);
                } else {
                    tmpLeft = 0;
                }
                min = Math.max(tmpLeft, tmpRight);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(15, solution.maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(20, solution.maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }
}
