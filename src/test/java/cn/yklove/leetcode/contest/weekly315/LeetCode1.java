package cn.yklove.leetcode.contest.weekly315;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int findMaxK(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int ans = -1;
            for (int num : nums) {
                if (set.contains(-1 * num)) {
                    ans = Math.max(Math.abs(num), ans);
                }
                set.add(num);
            }
            return ans;
        }
    }

}
