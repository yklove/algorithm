package cn.yklove.leetcode.contest.weekly234;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int numDifferentIntegers(String word) {
            Set<BigInteger> set = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    stringBuilder.append(c);
                } else {
                    stringBuilder.append(' ');
                }
            }
            String s = stringBuilder.toString();
            String[] s1 = s.split(" ");
            for (String s2 : s1) {
                if (s2.length() > 0) {
                    set.add(new BigInteger(s2));
                }
            }
            return set.size();
        }
    }

}
