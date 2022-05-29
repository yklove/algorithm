package cn.yklove.leetcode.contest.weekly293;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            Arrays.sort(special);
            int ans = 0;
            for (int i = 0; i < special.length - 1; i++) {
                ans = Math.max(special[i + 1] - special[i] - 1, ans);
            }
            ans = Math.max(special[0] - bottom, ans);
            ans = Math.max(top - special[special.length - 1], ans);
            return ans;
        }
    }

}
