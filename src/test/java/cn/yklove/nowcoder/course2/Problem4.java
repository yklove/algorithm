package cn.yklove.nowcoder.course2;

import org.junit.Assert;
import org.junit.Test;

public class Problem4 {

    /**
     * 将给定的数转换为字符串，原则如下:</br>
     * 1对应 a，2对应b，.....26对应z，</br>
     * 例如12258可以转换为"abbeh", "aveh", "abyh","lbeh" and "lyh"，个数为5，</br>
     * 编写一个函数，给出可以转换的不同字符串的个数。</br>
     */
    public class Solution {

        public int convert(int n) {
            return process(String.valueOf(n).toCharArray(), 0);
        }

        public int convertDp(int n) {
            return dp(String.valueOf(n).toCharArray(), 0);
        }

        /**
         * 暴力递归
         */
        private int process(char[] chars, int index) {
            if (index == chars.length) {
                return 1;
            }
            if (chars[index] == '0') {
                return 0;
            }
            if (index + 1 >= chars.length || (chars[index] - '0') * 10 + (chars[index + 1] - '0') > 26) {
                return process(chars, index + 1);
            }
            return process(chars, index + 1) + process(chars, index + 2);
        }

        /**
         * 暴力递归改动态规划
         */
        private int dp(char[] chars, int index) {
            int[] dp = new int[chars.length + 1];
            for (int i = chars.length; i >= 0; i--) {
                if (i == chars.length) {
                    dp[i] = 1;
                    continue;
                }
                if (chars[i] == '0') {
                    dp[i] = 0;
                    continue;
                }
                if (i + 1 >= chars.length || (chars[i] - '0') * 10 + (chars[i + 1] - '0') > 26) {
                    dp[i] = dp[i + 1];
                    continue;
                }
                dp[i] = dp[i + 1] + dp[i + 2];
            }
            return dp[0];
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(5, solution.convert(12258));
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.convertDp(12258), solution.convert(12258));
    }
}