package cn.yklove.leetcode.contest.weekly268;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int ans = 0;
            int tmp = capacity;
            for (int i = 0; i < plants.length; i++) {
                if (tmp < plants[i]) {
                    ans += (i * 2);
                    tmp = capacity;
                }
                ans += 1;
                tmp = tmp - plants[i];
            }
            return ans;
        }
    }

}
