package cn.yklove.leetcode.contest.weekly272;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public String addSpaces(String s, int[] spaces) {
            Set<Integer> set = new HashSet<>();
            for (int space : spaces) {
                set.add(space);
            }
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(set.contains(i)){
                    stringBuilder.append(" ");
                }
                stringBuilder.append(chars[i]);
            }
            return stringBuilder.toString();
        }
    }

}
