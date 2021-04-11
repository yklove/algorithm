package cn.yklove.leetcode.contest.spring2021;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(7, solution.orchestraLayout(5, 1, 0));
//        Assert.assertEquals(3, solution.orchestraLayout(5, 0, 2));
//        Assert.assertEquals(1, solution.orchestraLayout(5, 1, 3));
//        Assert.assertEquals(7, solution.orchestraLayout(5, 2, 2));
//        Assert.assertEquals(3, solution.orchestraLayout(3, 0, 2));
//        Assert.assertEquals(5, solution.orchestraLayout(4, 1, 2));
    }

    class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            return (int) (work(num, xPos, yPos));
        }

        private long work(long n, long a, long b) {
            long q = Math.min(Math.min(a, b), Math.min(n - a + 1, n - b + 1));
            long ans;
            if (a <= b) {
                q--;
                ans = 4 * (n - q) * q + a + b - 2 * (q + 1) + 1;
            } else
                ans = 4 * (n - q) * q - a - b + 2 * q + 1;
            return ans;
        }
    }

}
