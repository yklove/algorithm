package cn.yklove.leetcode.contest.weekly225;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int minCharacters(String a, String b) {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            int[][] dp1 = new int[a.length()][b.length()];

            for (int j = 0; j < aChars.length; j++) {
                for (int i = 0; i < bChars.length; i++) {
                    int tmp = (bChars[i] <= aChars[j]) ? 1 : 0;
                    if (i == 0 && j == 0) {
                        dp1[i][j] = tmp;
                    } else if (i == 0) {
                        dp1[i][j] = dp1[i][j - 1] + tmp;
                    } else if (j == 0) {
                        dp1[i][j] = dp1[i - 1][j] + tmp;
                    } else {
                        dp1[i][j] = Math.min(dp1[i - 1][j], dp1[i][j - 1]) + tmp;
                    }
                }
            }

            int[][] dp2 = new int[a.length()][a.length()];

            for (int i = 0; i < bChars.length; i++) {
                for (int j = 0; j < aChars.length; j++) {
                    int tmp = (aChars[j] <= bChars[i]) ? 1 : 0;
                    if (i == 0 && j == 0) {
                        dp2[i][j] = tmp;
                    } else if (i == 0) {
                        dp2[i][j] = dp2[i][j - 1] + tmp;
                    } else if (j == 0) {
                        dp2[i][j] = dp2[i - 1][j] + tmp;
                    } else {
                        dp2[i][j] = Math.min(dp2[i - 1][j], dp2[i][j - 1]) + tmp;
                    }
                }
            }
            Map<Character, Long> aGroupCount = groupCount(aChars);
            Map<Character, Long> bGroupCount = groupCount(bChars);
            long maxTheSame = 0;
            for (Map.Entry<Character, Long> characterLongEntry : aGroupCount.entrySet()) {
                maxTheSame = Math.max(maxTheSame, Math.min(characterLongEntry.getValue(), bGroupCount.getOrDefault(characterLongEntry.getKey(), 0L)));
            }
            long ans3 = aChars.length - maxTheSame;

            return (int) Math.min(Math.min(ans3 * 2, dp1[a.length() - 1][b.length() - 1]), dp2[b.length() - 1][a.length() - 1]);
        }

        private Map<Character, Long> groupCount(char[] aChars) {
            Character[] aCharacters = new Character[aChars.length];
            for (int i = 0; i < aChars.length; i++) {
                aCharacters[i] = aChars[i];
            }
            return Arrays.stream(aCharacters).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }


    }

    Solution solution = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.minCharacters("aba", "caa"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, solution.minCharacters("dabadd", "cda"));
    }

}
