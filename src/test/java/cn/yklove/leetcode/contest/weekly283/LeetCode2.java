package cn.yklove.leetcode.contest.weekly283;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {

//        public long minimalKSum(int[] nums, int k) {
//            long n = k + nums.length;
//            long sum = 0;
//            long maxSum = 0;
//            long maxCount = 0;
//            Set<Integer> set = new HashSet<>();
//            for (int num : nums) {
//                if (set.contains(num)) {
//                    System.out.println(num);
//                }
//                set.add(num);
//                sum += num;
//                if (num > n) {
//                    maxSum += num;
//                    maxCount++;
//                }
//            }
//            long x = n * (n + 1) / 2;
//            long y = (n - maxCount) * (n - maxCount + 1) / 2;
//            return x - (x - y) - (sum - maxSum);
//        }

        public long minimalKSum(int[] nums, int k) {
            int index = k;
            long sum = (long) k * (k + 1) / 2;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length && nums[i] <= index; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int num = nums[i];
                if (set.contains(num)) {
                    index++;
                    sum = sum - num + index;
                }
            }
            return sum;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(5, solution.minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, solution.minimalKSum(new int[]{1, 1, 5}, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(794, solution.minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35));
    }


}
