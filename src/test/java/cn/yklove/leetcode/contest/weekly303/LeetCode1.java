package cn.yklove.leetcode.contest.weekly303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public char repeatedCharacter(String s) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if(set.contains(c)){
                    return c;
                }
                set.add(c);
            }
            return 'a';
        }
    }

}
