package cn.yklove.leetcode.contest.weekly285;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int countHillValley(int[] nums) {
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
            }
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                    count++;
                } else if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                    count++;
                }
            }
            return count;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.countHillValley(new int[]{5, 7, 7, 1, 7}));

    }

}
