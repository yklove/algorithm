package cn.yklove.leetcode.contest.weekly204;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCode2 {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test() {
        Assert.assertEquals(solution.getMaxLen(new int[] { 1, -2, -3, 4 }), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.getMaxLen(new int[] { 0, 1, -2, -3, -4 }), 3);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.getMaxLen(new int[] { 1, 2, 3, 5, -6, 4, 0, 10 }), 4);
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.getMaxLen(new int[] { -1, -1, 1, -1, 1, 1, 1 }), 6);
    }

    @Test
    public void test5() {
        Assert.assertEquals(solution.getMaxLen(new int[] { 0, 0, 0, 0 }), 0);
    }

    @Test
    public void test6() {
        Assert.assertEquals(solution.getMaxLen(new int[] { -1, -1 }), 2);
    }

    class Solution {

        /**
         * 先不考虑0的情况。
         * 
         * 记录下起始位置，记为wz1。记录下第一次负数出现次数为奇次数的位置，记为wz2。
         * 其余情况，如果负数出现次数为偶次，答案是max(ret,当前位置-起始位置)。
         * 如果负数出现次数为奇次，答案是max(ret,当前位置-第一次负数出现位置)。
         * 
         * 如果要考虑0的话，实际上只需要更新起始位置即可，相当于将数组切开。
         * 
         * @param nums
         * @return
         */
        public int getMaxLen(int[] nums) {
            int ret = 0;
            // 记录小于0的个数
            int totf = 0;
            // wz1起始位置,奇数位置
            int wz1 = -1, wz2 = -2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    totf = 0;
                    wz1 = i;
                    wz2 = -2;
                } else {
                    if (nums[i] < 0) {
                        totf++;
                    }
                    if (totf % 2 == 0) {
                        ret = Math.max(ret, i - wz1);
                    } else {
                        if (wz2 == -2) {
                            wz2 = i;
                        } else {
                            ret = Math.max(ret, i - wz2);
                        }
                    }
                }
            }
            return ret;
        }

    }

}