package cn.yklove.leetcode.contest.weekly272;

/**
 * @author beamjl
 */
public class LeetCode1 {
    class Solution {
        public String firstPalindrome(String[] words) {
            for (String word : words) {
                if(word.equals(new StringBuilder(word).reverse().toString())){
                    return word;
                }
            }
            return "";
        }
    }
}
