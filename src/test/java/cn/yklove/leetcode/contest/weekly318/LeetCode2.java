package cn.yklove.leetcode.contest.weekly318;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode2 {
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long max = 0;
            Map<Integer, Integer> set = new HashMap<>();
            long sum = nums[0];
            set.put(nums[0], 0);
            int start = 0;
            int end = 1;
            if (k == 1) {
                max = nums[0];
            }
            while (true) {
                if (end >= nums.length) {
                    break;
                }
                if (end - start >= k) {
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                // 重复了
                if (set.containsKey(nums[end])) {
                    Integer tmpStart = set.get(nums[end]);
                    // 移除重复元素
                    while (start <= tmpStart) {
                        sum -= nums[start];
                        set.remove(nums[start]);
                        start++;
                    }
                    set.put(nums[end], end);
                    sum += nums[end];
                    end++;
                } else {
                    // 无重复元素
                    set.put(nums[end], end);
                    sum += nums[end];
                    end++;
                }
                if (end - start == k) {
                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(15, solution.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(24, solution.maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, solution.maximumSubarraySum(new int[]{3}, 1));
    }

    @Test
    public void test5() {
        Assert.assertEquals(5, solution.maximumSubarraySum(new int[]{5, 1, 3}, 1));
    }
}
