package cn.yklove.leetcode.contest.weekly266;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            if (quantities.length == 1) {
                return quantities[0];
            }
            int max = 0;
            for (int quantity : quantities) {
                max = Math.max(max, quantity);
            }
            int low = 1;
            int high = max;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = count(quantities, mid);

                if (midVal == n) {
                    return mid;
                } else if (midVal > n) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
            return -(low + 1);  // key not found.
        }

        private int count(int[] quantities, int mid) {
            int ans = 0;
            for (int quantity : quantities) {
                ans += ((quantity % mid == 0) ? quantity / mid : quantity / mid + 1);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
//        Assert.assertEquals(10000, solution.minimizedMaximum(1, new int[]{10000}));
        Assert.assertEquals(5, solution.minimizedMaximum(7, new int[]{15, 10, 10}));
//        Assert.assertEquals(3, solution.minimizedMaximum(6, new int[]{11,6}));
    }
}
