package cn.yklove.leetcode.contest.weekly216;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (String s : word1) {
                a.append(s);
            }
            for (String s : word2) {
                b.append(s);
            }
            return a.toString().equals(b.toString());
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {

    }
}
