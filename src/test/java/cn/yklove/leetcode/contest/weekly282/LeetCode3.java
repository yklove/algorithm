package cn.yklove.leetcode.contest.weekly282;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            long low = 1;
            long high = Long.MAX_VALUE - 1;

            while (low <= high) {
                long mid = low + (high - low) / 2;
                long midVal = midVal(mid, time);

                if (midVal < totalTrips)
                    low = mid + 1;
                else if (midVal >= totalTrips)
                    high = mid - 1;
                else
                    return mid; // key found
            }
            return low;  // key not found.
        }

        private long midVal(long mid, int[] time) {
            long midVal = 0;
            for (int i : time) {
                midVal += (mid / i);
                if(midVal < 0){
                    return Long.MAX_VALUE;
                }
            }
            return midVal;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.minimumTime(new int[]{1, 2, 3}, 5));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, solution.minimumTime(new int[]{2}, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(858, solution.minimumTime(new int[]{39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25}, 4187));
    }

}
