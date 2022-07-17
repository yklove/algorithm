package cn.yklove.leetcode.contest.weekly296;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int partitionArray(int[] nums, int k) {
            if (k == 0) {
                Set<Integer> set = new HashSet<>();
                for (int num : nums) {
                    set.add(num);
                }
                return set.size();
            }
            int ans = 0;
            int count = 0;
            while (count != nums.length) {
                ans++;
                int min = Integer.MAX_VALUE;
                int index = -1;
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    if (num < min) {
                        index = i;
                        min = num;
                    }
                }
                int max = min + k;
                for (int i = index - 1; i >= 0; i--) {
                    if (nums[i] >= nums[index] && nums[i] <= max) {
                        count++;
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] >= nums[index] && nums[i] <= max) {
                        count++;
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
                count++;
                nums[index] = Integer.MAX_VALUE;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.partitionArray(new int[]{5, 16, 3, 20, 9, 20, 16, 19, 6}, 4));
    }

}
