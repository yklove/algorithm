package cn.yklove.leetcode.contest.weekly213;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {


        public int countVowelStrings(int n) {
            return process(0, 0, n);
        }

        private int process(int length, int index, int n) {
            if (length == n) {
                return 1;
            }
            if (index >= 5) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i <= n - length; i++) {
                count += process(length + i, index + 1, n);
            }
            return count;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(5, solution.countVowelStrings(1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(15, solution.countVowelStrings(2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(66045, solution.countVowelStrings(33));
    }

    @Test
    public void test4() {
        Assert.assertEquals(316251, solution.countVowelStrings(50));
    }

    @Test
    public void test5() {
        long l = System.currentTimeMillis();
        Assert.assertEquals(249900, solution.countVowelStrings(47));
        System.out.println(System.currentTimeMillis() - l);
    }

}
