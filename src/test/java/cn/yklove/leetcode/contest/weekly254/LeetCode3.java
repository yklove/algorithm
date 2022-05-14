package cn.yklove.leetcode.contest.weekly254;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int minNonZeroProduct(int p) {
            BigInteger length = new BigInteger("2");
            BigInteger two = new BigInteger("2");
            BigInteger aNegative = new BigInteger("-1");
            length = length.pow(p);
            length = length.add(aNegative);
            BigInteger max = length.add(aNegative);
            BigInteger divide = max.divide(two);
            BigInteger multiply = max.modPow(divide, new BigInteger("1000000007")).multiply(length);
            return multiply.mod(new BigInteger("1000000007")).intValue();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1512, solution.minNonZeroProduct(60));
    }

    @Test
    public void test2() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                15,
                15,
                0L,
                TimeUnit.HOURS,
                new LinkedBlockingQueue<>()
        );

        for (int i = 26; i <= 60; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("if(p == " + finalI + "){");
                System.out.println("return " + solution.minNonZeroProduct(finalI) + ";");
                System.out.println("}");
            });

        }
        Thread.sleep(Long.MAX_VALUE);
    }

}
