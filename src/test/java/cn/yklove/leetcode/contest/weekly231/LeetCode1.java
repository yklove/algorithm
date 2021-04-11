package cn.yklove.leetcode.contest.weekly231;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean checkOnesSegment(String s) {
            char[] chars = s.toCharArray();
            int count = 0;
            boolean key = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1' && !key) {
                    key = true;
                    count++;
                }
                if (chars[i] == '0' && key) {
                    key = false;
                }
            }
            return count <= 1;
        }
    }


}
