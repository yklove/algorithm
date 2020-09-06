package cn.yklove.leetcode.contest.biweekly34;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int numWays(String s) {
            int count = 0;
            int[] index = new int[s.length() + 1];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                    index[count] = i;
                }
            }
            if (count == 0) {
                if (s.length() < 3) {
                    return 0;
                }
                int t = s.length() - 1;
                return new BigInteger(String.valueOf(t)).multiply(new BigInteger(String.valueOf(t - 1)))
                        .divide(new BigInteger(String.valueOf(2)))
                        .mod(new BigInteger(String.valueOf(1000000000 + 7))).intValue();
            }
            if (count % 3 != 0) {
                return 0;
            }
            return new BigInteger(String.valueOf(index[count / 3 + 1])).add(new BigInteger(String.valueOf(index[count / 3] * -1)))
                    .multiply(new BigInteger(String.valueOf(index[count / 3 * 2 + 1])).add(new BigInteger(String.valueOf(index[count / 3 * 2] * -1))))
                    .mod(new BigInteger(String.valueOf(1000000000 + 7))).intValue();
        }
    }


    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.numWays("10101"), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.numWays("1001"), 0);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.numWays("0000"), 3);
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.numWays("100100010100110"), 12);
    }

    @Test
    public void test5() {
        Assert.assertEquals(solution.numWays("111"), 1);
    }

    @Test
    public void test6() {
        Assert.assertEquals(solution.numWays("11"), 0);
    }

    @Test
    public void test7() {
        Assert.assertEquals(solution.numWays("00"), 0);
    }

    @Test
    public void test8() {
        Assert.assertEquals(solution.numWays("1111"), 0);
    }

    @Test
    public void test9() {
        Assert.assertEquals(solution.numWays("00000000"), 21);
    }

    @Test
    public void test10() {
    }


}
