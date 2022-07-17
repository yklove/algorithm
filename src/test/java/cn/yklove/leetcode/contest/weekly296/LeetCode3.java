package cn.yklove.leetcode.contest.weekly296;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            Map<Integer, Integer> mapKey = new HashMap<>();
            Map<Integer, Integer> mapValue = new HashMap<>();
            for (int[] operation : operations) {
                int key = operation[0];
                int value = operation[1];
                if (mapValue.containsKey(key)) {
                    Integer oldKey = mapValue.get(key);
                    mapKey.put(oldKey, value);
                    mapValue.put(value, oldKey);
                } else {
                    mapKey.put(key, value);
                    mapValue.put(value, key);
                }
            }
            int[] ans = new int[nums.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = mapKey.getOrDefault(nums[i],nums[i]);
            }
            return ans;
        }
    }

}
