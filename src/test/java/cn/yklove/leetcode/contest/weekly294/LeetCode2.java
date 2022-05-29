package cn.yklove.leetcode.contest.weekly294;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int[] tmp = new int[capacity.length];
            for (int i = 0; i < capacity.length; i++) {
                tmp[i] = capacity[i] - rocks[i];
            }
            int ans = 0;
            Arrays.sort(tmp);
            for (int i : tmp) {
                if (i == 0) {
                    ans++;
                } else {
                    if (additionalRocks <= 0 || additionalRocks - i < 0) {
                        break;
                    }
                    additionalRocks -= i;
                    ans++;
                }
            }
            return ans;
        }
    }

}
