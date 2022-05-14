package cn.yklove.leetcode.contest.weekly292;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public String largestGoodInteger(String num) {
            char[] chars = num.toCharArray();
            char tmpChar = 'a';
            int count = 0;
            int max = -1;
            for (char aChar : chars) {
                if (aChar == tmpChar) {
                    count++;
                } else {
                    tmpChar = aChar;
                    count = 1;
                }
                if (count == 3) {
                    max = Math.max(max, aChar - '0');
                }
            }
            if (max == -1) {
                return "";
            }
            return max + "" + max + "" + max;
        }
    }

}
