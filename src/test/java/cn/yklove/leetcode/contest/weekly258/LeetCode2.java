package cn.yklove.leetcode.contest.weekly258;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            Map<Double, Integer> map = new HashMap<>();
            for (int[] rectangle : rectangles) {
                double i = rectangle[0] / (double) rectangle[1];
                Integer count = map.getOrDefault(i, 0);
                map.put(i, count + 1);
            }
            long ans = 0;
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    continue;
                }
                long tmp = 0;
                for (int i = entry.getValue() - 1; i > 0; i--) {
                    tmp += i;
                }
                ans += tmp;
            }
            return ans;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(6, solution.interchangeableRectangles(new int[][]{
                {4, 8},
                {3, 6},
                {10, 20},
                {15, 30}
        }));
    }
}
