package cn.yklove.leetcode.contest.weekly251;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                stringBuilder.append((int) c - 'a' + 1);
            }
            String s1 = stringBuilder.toString();
            for (int i = 0; i < k; i++) {
                int sum = 0;
                for (char c : s1.toCharArray()) {
                    sum += (c - '0');
                }
                s1 = String.valueOf(sum);
            }
            return Integer.parseInt(s1);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(36, solution.getLucky("iiii", 1));
    }
}
