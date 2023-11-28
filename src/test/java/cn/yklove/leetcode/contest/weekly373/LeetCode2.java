package cn.yklove.leetcode.contest.weekly373;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode2 {

    /**
     * 给你一个字符串 s 和一个正整数 k 。
     * 用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。
     * 如果某个字符串满足以下条件，则称其为 美丽字符串 ：
     * vowels == consonants，即元音字母和辅音字母的数量相等。
     * (vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。
     * 返回字符串 s 中 非空美丽子字符串 的数量。
     * 子字符串是字符串中的一个连续字符序列。
     * 英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。
     * 英语中的 辅音字母 为除了元音字母之外的所有字母。
     */
    class Solution {
        public int beautifulSubstrings(String s, int k) {
            return dfs(s, 0, 0, 0, 0, k);
        }

        private int dfs(String s, int index1, int index2, int vowels, int consonants, int k) {
            if (vowels != 0 && consonants != 0) {
                if (vowels == consonants && (vowels + consonants) % k == 0) {
                    return 1;
                }
            }
            int count = 0;
            for (int i = index1; i < s.length(); i++) {
                for (int j = Math.max(index2 + 1,i+1); j < s.length(); j++) {
                    boolean tmp = isE(s.charAt(j));
                    count += dfs(s, i, j, vowels + (tmp ? 1 : 0), consonants + (tmp ? 0 : 1), k);
                }
                if (isE(s.charAt(i))) {
                    vowels = vowels - 1;
                } else {
                    consonants = consonants - 1;
                }
            }
            return count;
        }

        private boolean isE(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
            return false;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.beautifulSubstrings("baeyh", 2));
    }
}
