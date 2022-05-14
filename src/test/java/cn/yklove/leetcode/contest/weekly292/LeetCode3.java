package cn.yklove.leetcode.contest.weekly292;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {

        private static final int mod = 1000000007;

        private long[] dp;

        public int countTexts(String pressedKeys) {
            char[] chars = pressedKeys.toCharArray();
            dp = new long[chars.length + 1];
            dp[chars.length - 1] = 1;
            dp[chars.length] = 1;
            for (int i = chars.length - 2; i >= 0; i--) {
                int end = i;
                for (int j = end + 1; j < chars.length && (j-i) < 5; j++) {
                    if (chars[j] == chars[i]) {
                        end = j;
                    } else {
                        break;
                    }
                }
                if (i == end) {
                    dp[i] = dp[i + 1];
                } else {
                    switch (chars[i]) {
                        case '7':
                        case '9':
                            for (int j = 1; j <= Math.min(4, end - i + 1) && (i + j) <= chars.length; j++) {
                                dp[i] += dp[i + j] % mod;
                            }
                            break;
                        default:
                            for (int j = 1; j <= Math.min(3, end - i + 1) && (i + j) <= chars.length; j++) {
                                dp[i] += dp[i + j] % mod;
                            }
                    }
                    dp[i] = dp[i] % mod;
                }
            }
            return (int) dp[0];
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.countTexts("22233"), 8);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.countTexts("222222222222222222222222222222222222"), 82876089);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly292/LeetCode3-test3.txt"));
        String s = in.nextLine();
        long time = System.currentTimeMillis();
        Assert.assertEquals(solution.countTexts(s), 111787461);
        System.out.println(System.currentTimeMillis() - time);
    }

}
