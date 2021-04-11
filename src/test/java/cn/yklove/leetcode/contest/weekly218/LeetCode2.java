package cn.yklove.leetcode.contest.weekly218;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
            for (int num : nums) {
                if (map.getOrDefault(num, 0) > 0 &&
                        map.getOrDefault(k - num, 0) > 0
                        && (num != k - num || map.get(num) > 1)
                ) {
                    ans++;
                    map.put(k - num, map.getOrDefault(k - num, 0) - 1);
                    map.put(num, map.getOrDefault(num, 0) - 1);
                }
            }
            return ans;
        }
    }


    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }
}
