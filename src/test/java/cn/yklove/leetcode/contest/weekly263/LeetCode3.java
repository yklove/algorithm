package cn.yklove.leetcode.contest.weekly263;

import org.junit.Assert;
import org.junit.Test;

import java.net.DatagramSocket;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int countMaxOrSubsets(int[] nums) {

            int max = 0;
            for (int num : nums) {
                max |= num;
            }
            return process(nums, 0, max, 0);
        }

        private int process(int[] nums, int index, int max, int previous) {
            if (index >= nums.length) {
                return 0;
            }
            int count = 0;
            // 不选
            count += process(nums, index + 1, max, previous);
            // 选
            int tmp = nums[index] | previous;
            if (tmp == max) {
                int num = nums.length - index - 1;
                count += (int) Math.pow(2.0, num);
            } else {
                count += process(nums, index + 1, max, tmp);
            }
            return count;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}), 6);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.countMaxOrSubsets(new int[]{3, 1}), 2);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.countMaxOrSubsets(new int[]{2, 2, 2}), 7);
    }
}
