package cn.yklove.leetcode.contest.weekly271;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int countPoints(String rings) {
            int[][] ans = new int[10][3];
            char[] chars = rings.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    if (chars[i - 1] == 'R') {
                        ans[chars[i] - '0'][0] = 1;
                    } else if (chars[i - 1] == 'G') {
                        ans[chars[i] - '0'][1] = 1;
                    } else if (chars[i - 1] == 'B') {
                        ans[chars[i] - '0'][2] = 1;
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < ans.length; i++) {
                result += (ans[i][0] == 1 && ans[i][1] == 1 && ans[i][2] == 1) ? 1 : 0;
            }
            return result;
        }
    }

}
