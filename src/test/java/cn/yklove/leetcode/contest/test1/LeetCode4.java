package cn.yklove.leetcode.contest.test1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int keyboard(int k, int n) {
            return process(26, n, k).mod(new BigInteger("1000000007")).intValue();
        }

        private BigInteger process(int count, int n, int k) {
            if (k <= 0) {
                count--;
            }
            if (count <= 0 || n <= 0) {
                return new BigInteger(String.valueOf(1));
            }
            if (n == 1) {
                return new BigInteger(String.valueOf(count));
            }
            return process(count, n - 1, k - 1).multiply(new BigInteger(String.valueOf(count)));
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(650, solution.keyboard(1, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(26, solution.keyboard(1, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(15600, solution.keyboard(1, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(676, solution.keyboard(2, 2));
    }

    @Test
    public void test5() {
        Assert.assertEquals(16900, solution.keyboard(2, 3));
    }

    @Test
    public void test6() {
        Assert.assertEquals(180550339, solution.keyboard(5, 26 * 5));
    }

    @Test
    public void test7() {
        Assert.assertEquals(11881376, solution.keyboard(5, 5));
    }
}
