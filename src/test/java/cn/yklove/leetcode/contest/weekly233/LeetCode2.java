package cn.yklove.leetcode.contest.weekly233;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<int[]> minsell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            PriorityQueue<int[]> maxbuy = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            for (int[] o : orders) {
                if (o[2] == 1) {
                    while (o[1] > 0 && !maxbuy.isEmpty() && o[0] <= maxbuy.peek()[0]) {
                        int[] buy = maxbuy.poll();
                        if (o[1] >= buy[1]) {
                            o[1] -= buy[1];
                        } else {
                            buy[1] -= o[1];
                            o[1] = 0;
                            maxbuy.offer(buy);
                        }
                    }
                    if (o[1] > 0) minsell.offer(o);
                } else {
                    while (o[1] > 0 && !minsell.isEmpty() && o[0] >= minsell.peek()[0]) {
                        int[] sell = minsell.poll();
                        if (o[1] >= sell[1]) {
                            o[1] -= sell[1];
                        } else {
                            sell[1] -= o[1];
                            o[1] = 0;
                            minsell.offer(sell);
                        }
                    }
                    if (o[1] > 0) maxbuy.offer(o);
                }
            }
            int res = 0, mod = (int) 1e9 + 7;
            while (!minsell.isEmpty()) {
                res += minsell.poll()[1] % mod;
                res %= mod;
            }
            while (!maxbuy.isEmpty()) {
                res += maxbuy.poll()[1] % mod;
                res %= mod;
            }
            return res;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(6, solution.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        Assert.assertEquals(999999984, solution.getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}}));
        Assert.assertEquals(82, solution.getNumberOfBacklogOrders(new int[][]{{27, 30, 0}, {10, 10, 1}, {28, 17, 1}, {19, 28, 0}, {16, 8, 1}, {14, 22, 0}, {12, 18, 1}, {3, 15, 0}, {25, 6, 1}}));
        Assert.assertEquals(102, solution.getNumberOfBacklogOrders(new int[][]{{23, 8, 0}, {28, 29, 1}, {11, 30, 1}, {30, 25, 0}, {26, 9, 0}, {3, 21, 0}, {28, 19, 1}, {19, 30, 0}, {20, 9, 1}, {17, 6, 0}}));
    }

}
