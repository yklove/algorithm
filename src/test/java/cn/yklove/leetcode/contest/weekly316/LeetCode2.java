package cn.yklove.leetcode.contest.weekly316;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int subarrayGCD(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int gcd = nums[i];
                for (int j = i; j < nums.length; j++) {
                    gcd = gcd(gcd, nums[j]);
                    if (gcd == k) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private int gcd(int n, int m) {
            int z = 0;
            while (m % n != 0) {
                z = m % n;
                m = n;
                n = z;
            }
            return n;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, solution.subarrayGCD(new int[]{3, 12, 9, 6}, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(10, solution.subarrayGCD(new int[]{3, 3, 4, 1, 2}, 1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(20, solution.subarrayGCD(new int[]{15, 11, 5, 19, 9, 9, 4}, 1));
    }

}
