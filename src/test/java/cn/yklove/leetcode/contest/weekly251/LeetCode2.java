package cn.yklove.leetcode.contest.weekly251;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public String maximumNumber(String num, int[] change) {
            StringBuilder stringBuilder = new StringBuilder();
            int key = 0;
            for (char c : num.toCharArray()) {
                int number = c - '0';
                if ((key == 0 || key == 1) && change[number] >= number) {
                    stringBuilder.append(change[number]);
                    if (change[number] != number) {
                        key = 1;
                    }
                } else {
                    if (key == 1) {
                        key = 2;
                    }
                    stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals("339", solution.maximumNumber("330",
                new int[]{9, 3, 6, 3, 7, 3, 1, 4, 5, 8}));
    }

    @Test
    public void test2() {
        Assert.assertEquals("974676", solution.maximumNumber("214010",
                new int[]{6, 7, 9, 7, 4, 0, 3, 4, 4, 7}));
    }

    @Test
    public void test3() {
        Assert.assertEquals("974676", solution.maximumNumber("214010",
                new int[]{6, 7, 9, 7, 4, 0, 3, 4, 4, 7}));
    }

}
