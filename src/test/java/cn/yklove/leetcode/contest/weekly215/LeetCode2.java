package cn.yklove.leetcode.contest.weekly215;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            char[] word1Chars = word1.toCharArray();
            char[] word2Chars = word2.toCharArray();
            int[] word1Count = new int[26];
            int[] word2Count = new int[26];
            for (int i = 0; i < word1.length(); i++) {
                word1Count[word1Chars[i] - 'a']++;
                word2Count[word2Chars[i] - 'a']++;
            }
            List<Integer> word1List = new ArrayList<>();
            List<Integer> word2List = new ArrayList<>();
            for (int i = 0; i < word1Count.length; i++) {
                if (word1Count[i] == 0 && word2Count[i] != 0 || word1Count[i] != 0 && word2Count[i] == 0) {
                    return false;
                }
                if (word1Count[i] != 0) {
                    word1List.add(word1Count[i]);
                    word2List.add(word2Count[i]);
                }
            }
            Collections.sort(word1List);
            Collections.sort(word2List);
            for (int i = 0; i < word1List.size(); i++) {
                if (!word1List.get(i).equals(word2List.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.closeStrings("abc", "bca"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.closeStrings("a", "aa"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(solution.closeStrings("cabbba", "abbccc"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(solution.closeStrings("cabbba", "aabbss"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(solution.closeStrings("uau", "ssx"));
    }
}
