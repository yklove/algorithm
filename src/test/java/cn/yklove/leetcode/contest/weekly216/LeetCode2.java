package cn.yklove.leetcode.contest.weekly216;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public String getSmallestString(int n, int k) {
            int average = k / n;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = average;
            }
            int remainder = k % n;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (remainder == 0) {
                    break;
                }
                int min = Math.min(26 - arr[i], remainder);
                arr[i] += min;
                remainder -= min;
            }
            int start = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = start; j < i; j++) {
                    if (arr[i] >= 26) {
                        break;
                    }
                    int min = Math.min(26 - arr[i], arr[j] - 1);
                    arr[i] += min;
                    arr[j] -= min;
                    if (arr[j] == 1) {
                        start = j;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : arr) {
                stringBuilder.append((char) ('a' + (i - 1)));
            }
            return stringBuilder.toString();
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals("aay", solution.getSmallestString(3, 27));
    }

    @Test
    public void test2() {
        Assert.assertEquals("aaszz", solution.getSmallestString(5, 73));
    }
}
