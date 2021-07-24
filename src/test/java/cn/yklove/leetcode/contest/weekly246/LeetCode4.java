package cn.yklove.leetcode.contest.weekly246;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int[] minDifference(int[] nums, int[][] queries) {
            Map<Integer, TreeSet<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                TreeSet<Integer> set = map.getOrDefault(nums[i], new TreeSet<>());
                set.add(i);
                map.put(nums[i], set);
            }
            int[] ans = new int[queries.length];
            Arrays.fill(ans, -1);
            for (int i = 0; i < queries.length; i++) {
                int[] querie = queries[i];
                int start = querie[0];
                int end = querie[1];
                // 枚举差值
                for (int j = 1; j <= 99; j++) {
                    boolean answer = false;
                    // 判断是否存在该差值
                    for (int k = start; k <= end; k++) {
                        TreeSet<Integer> set = map.getOrDefault(nums[k] + j, new TreeSet<>());
                        TreeSet<Integer> set2 = map.getOrDefault(nums[k] - j, new TreeSet<>());
                        Integer floor = set.floor(end);
                        Integer floor2 = set2.floor(end);
                        if (Objects.nonNull(floor) && floor != k && floor >= start && floor <= end
                                || Objects.nonNull(floor2) && floor2 != k && floor2 >= start && floor2 <= end) {
                            ans[i] = j;
                            answer = true;
                            break;
                        }
                    }
                    if (answer) {
                        break;
                    }
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();


    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 1, 4, 1}, solution.minDifference(new int[]{1, 3, 4, 8},
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 3}}));
    }


}
