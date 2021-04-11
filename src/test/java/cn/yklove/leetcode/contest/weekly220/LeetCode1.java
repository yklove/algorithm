package cn.yklove.leetcode.contest.weekly220;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public String reformatNumber(String number) {
            number = number.replaceAll(" ", "").replaceAll("-", "");
            char[] chars = number.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            for (i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (i != 0 && i % 3 == 0) {
                    stringBuilder.append("-");
                    if (chars.length - i <= 4) {
                        break;
                    }
                }
                stringBuilder.append(aChar);
            }
            if (chars.length - i == 4) {
                stringBuilder.append(number, i, i + 2).append("-").append(number, i + 2, i + 4);
            } else if (chars.length - i == 3) {
                stringBuilder.append(number, i, i + 3);
            } else if (chars.length - i == 2) {
                stringBuilder.append(number, i, i + 2);
            } else if (chars.length - i == 1) {
                stringBuilder.delete(i, i + 1);
                stringBuilder.append(chars[i]);
                stringBuilder.insert(i - 1, "-");
            }
            return stringBuilder.toString();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals("123-456", solution.reformatNumber("1-23-45 6"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("123-45-67", solution.reformatNumber("123 4-567"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("13", solution.reformatNumber("13"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("99-64", solution.reformatNumber("9964-"));
    }

}
