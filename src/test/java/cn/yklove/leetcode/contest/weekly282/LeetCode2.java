package cn.yklove.leetcode.contest.weekly282;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int minSteps(String s, String t) {
            Map<Character, Integer> smap = new HashMap<>();
            Map<Character, Integer> tmap = new HashMap<>();
            for (char c : s.toCharArray()) {
                smap.put(c, smap.getOrDefault(c, 0) + 1);
            }
            for (char c : t.toCharArray()) {
                tmap.put(c, tmap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
                Character key = entry.getKey();
                int min = Math.min(entry.getValue(), tmap.getOrDefault(key, 0));
                smap.put(key, smap.getOrDefault(key, 0) - min);
                tmap.put(key, tmap.getOrDefault(key, 0) - min);
            }
            int ans = 0;
            for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
                ans += entry.getValue();
            }
            for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
                ans += entry.getValue();
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertEquals(7,solution.minSteps("leetcode","coats"));
    }

}
