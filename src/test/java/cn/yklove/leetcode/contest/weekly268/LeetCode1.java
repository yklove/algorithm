package cn.yklove.leetcode.contest.weekly268;

/**
 * @author beamjl
 */
public class LeetCode1 {
    class Solution {
        public int maxDistance(int[] colors) {
            int ans = 0;
            for (int i = 0; i < colors.length; i++) {
                for (int j = colors.length - 1; j > i; j--) {
                    if (colors[j] != colors[i]) {
                        ans = Math.max(ans, j - i);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
