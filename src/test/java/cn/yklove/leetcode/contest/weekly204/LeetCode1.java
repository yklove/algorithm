package cn.yklove.leetcode.contest.weekly204;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCode1 {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test() {
        Assert.assertTrue(solution.containsPattern(new int[] { 1, 2, 4, 4, 4, 4 }, 1, 3));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.containsPattern(new int[] { 1, 2, 1, 2, 1, 3 }, 2, 3));
    }

    @Test
    public void test3() {
        Assert.assertTrue(solution.containsPattern(new int[] { 1, 2, 1, 2, 1, 1, 1, 3 }, 2, 2));
    }

    @Test
    public void test4() {
        Assert.assertFalse(solution.containsPattern(new int[] { 1, 2, 3, 1, 2 }, 2, 2));
    }

    class Solution {

        /**
         * 暴力求解…
         * @param arr
         * @param m
         * @param k
         * @return
         */
        public boolean containsPattern(int[] arr, int m, int k) {
            for (int i = 0; i <= arr.length - m; i++) {
                int count = 1;
                for (int j = i + m; j <= arr.length - m; j++) {
                    boolean key = true;
                    for (int p = 0; p < m; p++) {
                        if (arr[i + p] != arr[j + p]) {
                            key = false;
                            break;
                        }
                    }
                    if (key) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == k) {
                    return true;
                }
            }
            return false;
        }

    }

}