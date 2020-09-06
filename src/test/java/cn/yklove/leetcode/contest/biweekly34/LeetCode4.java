package cn.yklove.leetcode.contest.biweekly34;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {

        private BigInteger bigInteger;

        private BigInteger[][] map;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            map = new BigInteger[locations.length + 1][fuel + 1];
            bigInteger = new BigInteger("0");
            if (start == finish) {
                bigInteger = bigInteger.add(new BigInteger("1"));
            }
            for (int i = 0; i < locations.length; i++) {
                if (i != start) {
                    bigInteger = bigInteger.add(process(locations, i, finish, fuel - Math.abs(locations[start] - locations[i])));
                }
            }
            return bigInteger.mod(new BigInteger(String.valueOf(1000000000 + 7))).intValue();
        }

        public BigInteger process(int[] locations, int start, int finish, int fuel) {
            if (fuel >= 0 && map[start][fuel] != null) {
                return map[start][fuel];
            }
            BigInteger count = new BigInteger("0");
            if (start == finish && fuel >= 0) {
                bigInteger = bigInteger.add(new BigInteger("1"));
                count = count.add(new BigInteger("1"));
            }
            if (fuel <= 0) {
                return count;
            }
            for (int i = 0; i < locations.length; i++) {
                if (i != start) {
                    BigInteger process = process(locations, i, finish, fuel - Math.abs(locations[start] - locations[i]));
                    count = count.add(process);
                }
            }
            map[start][fuel] = count;
            return count;
        }
    }


    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.countRoutes(new int[]{4, 3, 1}, 1, 0, 6), 5);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.countRoutes(new int[]{5, 2, 1}, 0, 2, 3), 0);
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.countRoutes(new int[]{2, 1, 5}, 0, 0, 3), 2);
    }

    @Test
    public void test5() {
        Assert.assertEquals(solution.countRoutes(new int[]{1, 2, 3}, 0, 2, 40), 615088286);
    }

}
