package cn.yklove.leetcode.contest.weekly266;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int countVowelSubstrings(String word) {
            char[] chars = word.toCharArray();
            return process(chars, 0);
        }

        private int process(char[] chars, int start) {
            if (start >= chars.length) {
                return 0;
            }
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    set.add(0);
                } else if (chars[i] == 'e') {
                    set.add(1);
                } else if (chars[i] == 'i') {
                    set.add(2);
                } else if (chars[i] == 'o') {
                    set.add(3);
                } else if (chars[i] == 'u') {
                    set.add(4);
                } else {
                    break;
                }
                if (set.size() >= 5) {
                    count++;
                }
            }
            return count + process(chars, start + 1);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.countVowelSubstrings("aeiouu"));
    }

}
