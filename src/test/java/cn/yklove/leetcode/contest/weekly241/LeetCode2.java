package cn.yklove.leetcode.contest.weekly241;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int minSwaps(String s) {
            int countZero = 0;
            int countOne = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            if (Math.abs(countOne - countZero) > 1) {
                return -1;
            }
            int ans = 0;
            boolean key = true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == (key ? '0' : '1')) {
                    ans++;
                }
                key = !key;
            }
            int ans2 = 0;
            boolean key2 = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == (key2 ? '0' : '1')) {
                    ans2++;
                }
                key2 = !key2;
            }
            return Math.min(ans % 2 == 0 ? ans / 2 : Integer.MAX_VALUE, ans2 % 2 == 0 ? ans2 / 2 : Integer.MAX_VALUE);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        // 65
        Assert.assertEquals(solution.minSwaps("100"), 1);
        Assert.assertEquals(solution.minSwaps("1110000000100001010100101010000101010101001000001110101000010111101100000111110001000111010111101100001100001001100101011110100011111100000000100011111011110111111011110111010100111101011111111101101100101010110000011110110100101111000100000001100000"), 60);
        Assert.assertEquals(solution.minSwaps("1001"), 1);
        Assert.assertEquals(solution.minSwaps("111000"), 1);
    }

}
