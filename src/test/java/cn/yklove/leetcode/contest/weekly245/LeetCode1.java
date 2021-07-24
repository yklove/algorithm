package cn.yklove.leetcode.contest.weekly245;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean makeEqual(String[] words) {
            Map<Character, Integer> map = new HashMap<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                if (characterIntegerEntry.getValue() % words.length != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
