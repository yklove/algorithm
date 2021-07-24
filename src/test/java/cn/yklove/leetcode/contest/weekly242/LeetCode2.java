package cn.yklove.leetcode.contest.weekly242;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            if (hour < dist.length - 1) {
                return -1;
            }
            // 最大的速度
            int max = 0;
            for (int i : dist) {
                max = Math.max(i, max);
            }
            double process = process(Arrays.copyOf(dist, dist.length - 1), max);
            process = Math.ceil(process);
            if ((int) process == (int) hour) {
                return Math.max(max, (int) (dist[dist.length - 1] / (hour - (int) hour)));
            }
            // 二分1~max
            int low = 1;
            int high = max;
            double midVal;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                midVal = process(dist, mid);

                if (midVal > hour)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return low;
        }

        private double process(int[] a, int k) {
            double ans = 0;
            for (int i : a) {
                // 向上取整
                ans = Math.ceil(ans);
                ans += i / (double) k;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.minSpeedOnTime(new int[]{1, 3, 2}, 6));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, solution.minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
    }

    @Test
    public void test4() {
        Assert.assertEquals(10000000, solution.minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
    }

    @Test
    public void test5() {
        Assert.assertEquals(100000, solution.minSpeedOnTime(new int[]{1, 100000, 1}, 2.01));
    }


}
