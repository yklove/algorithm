package cn.yklove.leetcode.contest.weekly295;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int rearrangeCharacters(String s, String target) {
            Map<Character, Integer> mapTarget = new HashMap<>();
            Map<Character, Integer> mapS = new HashMap<>();
            for (char c : target.toCharArray()) {
                mapTarget.put(c, mapTarget.getOrDefault(c, 0) + 1);
            }
            for (char c : s.toCharArray()) {
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            }
            int ans = Integer.MAX_VALUE;
            for (char c : target.toCharArray()) {
                ans = Math.min(mapS.getOrDefault(c, 0) / mapTarget.get(c), ans);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertEquals(2,solution.rearrangeCharacters("ilovecodingonleetcode","code"));
    }

}
