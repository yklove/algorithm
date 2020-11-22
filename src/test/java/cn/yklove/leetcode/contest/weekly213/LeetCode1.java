package cn.yklove.leetcode.contest.weekly213;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < pieces.length; i++) {
                map.put(pieces[i][0], i);
            }
            int count = 0;
            while (count < arr.length) {
                if (!map.containsKey(arr[count])) {
                    return false;
                }
                int[] prece = pieces[map.get(arr[count])];
                for (int i = 0; i < prece.length; i++) {
                    if (arr[count] != prece[i]) {
                        return false;
                    }
                    count++;
                }
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test4() {
        Assert.assertTrue(solution.canFormArray(new int[]{91, 4, 64, 78},
                new int[][]{
                        {78}, {4, 64}, {91}
                }));
    }

    @Test
    public void test1() {
        Assert.assertTrue(solution.canFormArray(new int[]{85},
                new int[][]{
                        {85}
                }));
    }

    @Test
    public void test2() {
        Assert.assertTrue(solution.canFormArray(new int[]{15, 88},
                new int[][]{
                        {88}, {15}
                }));
    }

    @Test
    public void test3() {
        Assert.assertFalse(solution.canFormArray(new int[]{49, 18, 16},
                new int[][]{
                        {16, 18, 49}
                }));
    }

}
