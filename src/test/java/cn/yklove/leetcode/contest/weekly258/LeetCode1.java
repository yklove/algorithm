package cn.yklove.leetcode.contest.weekly258;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public String reversePrefix(String word, char ch) {
            int i = word.indexOf(ch);
            if (i == -1 || i == 0) {
                return word;
            }
            String substring = word.substring(0, i + 1);
            return new StringBuilder(substring).reverse().append(word.substring(i + 1)).toString();
        }
    }

}
