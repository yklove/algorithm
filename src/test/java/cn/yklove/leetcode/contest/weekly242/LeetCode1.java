package cn.yklove.leetcode.contest.weekly242;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean checkZeroOnes(String s) {
            int max0 = 0;
            int max1 = 0;
            char tmp = 'a';
            int tmpCount = 0;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == tmp) {
                    tmpCount++;
                } else {
                    if (tmp == '0') {
                        max0 = Math.max(max0, tmpCount);
                    } else if (tmp == '1') {
                        max1 = Math.max(max1, tmpCount);
                    }
                    tmpCount = 1;
                    tmp = aChar;
                }
            }
            if (tmp == '0') {
                max0 = Math.max(max0, tmpCount);
            } else if (tmp == '1') {
                max1 = Math.max(max1, tmpCount);
            }
            return max1 > max0;
        }
    }

}
