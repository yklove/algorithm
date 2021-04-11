package cn.yklove.leetcode.contest.weekly220;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int start = 0;
            int end = 1;
            int sum = nums[0];
            int ans = sum;
            set.add(nums[0]);
            while (end != nums.length) {
                // 不存在
                if (!set.contains(nums[end])) {
                    sum += nums[end];
                    set.add(nums[end]);
                    ans = Math.max(ans, sum);
                    end++;
                } else {
                    // 移动左侧
                    while (set.contains(nums[end])) {
                        sum -= nums[start];
                        set.remove(nums[start]);
                        start++;
                    }
                }
            }
            return ans;
        }
    }



}
