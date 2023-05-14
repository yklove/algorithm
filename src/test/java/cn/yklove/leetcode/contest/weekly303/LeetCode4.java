package cn.yklove.leetcode.contest.weekly303;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        public long countExcellentPairs(int[] nums, int k) {
            HashSet<Integer> set = new HashSet<>();
            long map[] = new long[30], count = 0;
            for (int num : nums) {
                map[Integer.bitCount(num)] += set.add(num) ? 1 : 0;
            }
            System.out.println(Arrays.toString(map));
            for (int i = 0; i < 30; i++) {
                for (int j = Math.max(0, k - i); j < 30; j++) {
                    count += map[i] * map[j];
                }
            }
            return count;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
//        solution.countExcellentPairs(new int[]{1, 2, 3, 1}, 3);
        Assert.assertEquals(solution.countExcellentPairs(new int[]{1, 536870911}, 30), 3);
    }

}
