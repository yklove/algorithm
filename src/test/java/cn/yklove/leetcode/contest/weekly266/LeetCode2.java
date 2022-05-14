package cn.yklove.leetcode.contest.weekly266;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public long countVowels(String word) {
            char[] chars = word.toCharArray();
            long[] tmp = new long[chars.length];
            if (isTrue(chars[0])) {
                tmp[0] = 1;
            }
            long ans = tmp[0];
            for (int i = 1; i < chars.length; i++) {
                if (isTrue(chars[i])) {
                    tmp[i] = tmp[i - 1] + 1;
                } else {
                    tmp[i] = tmp[i - 1];
                }
                ans += tmp[i];
            }
            long sum = ans;
            for (int i = 1; i < chars.length; i++) {
                if (!isTrue(chars[i - 1])) {
                    ans += sum;
                } else {
                    sum = sum - (chars.length - i + 1);
                    ans += sum;
                }
            }
            return ans;
        }

        private boolean isTrue(char k) {
            return k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u';
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(237, solution.countVowels("noosabasboosa"));
    }

}
