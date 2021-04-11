package cn.yklove.leetcode.contest.weekly225;

import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public String maximumTime(String time) {
            char[] timeChars = time.toCharArray();
            if (timeChars[0] == '?') {
                if (timeChars[1] == '?' || Integer.parseInt(String.valueOf(timeChars[1])) <= 3) {
                    timeChars[0] = '2';
                } else {
                    timeChars[0] = '1';
                }
            }
            if (timeChars[1] == '?') {
                if (timeChars[0] == '2') {
                    timeChars[1] = '3';
                } else {
                    timeChars[1] = '9';
                }
            }
            if (timeChars[3] == '?') {
                timeChars[3] = '5';
            }
            if (timeChars[4] == '?') {
                timeChars[4] = '9';
            }
            return new String(timeChars);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.maximumTime("2?:?0");

    }


}
