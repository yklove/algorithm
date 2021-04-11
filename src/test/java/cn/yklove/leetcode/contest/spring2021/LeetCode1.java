package cn.yklove.leetcode.contest.spring2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    Solution solution = new Solution();

    @Test
    public void test() {
        System.out.println(solution.purchasePlans(new int[]{2, 2, 1, 9}, 10));
        System.out.println(solution.purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(solution.purchasePlans(new int[]{1, 1, 1, 1}, 2));
        System.out.println(solution.purchasePlans(new int[]{1, 3, 3, 5}, 6));
    }

    class Solution {
        public int purchasePlans(int[] nums, int target) {
            long ans = 0;
            // 排序
            Arrays.sort(nums);
            // 1 2 2 9
            for (int i = 0; i < nums.length; i++) {
                int max = target - nums[i];
                int tmp = binarySearch(nums, i + 1, nums.length, max);
                ans += (tmp - i);
                ans %= 1000000007;
            }
            return (int) ans;
        }

        private int binarySearch(int[] a, int fromIndex, int toIndex,
                                 int key) {
            int low = fromIndex;
            int high = toIndex - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];

                if (midVal <= key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
//                else
//                    return mid; // key found
            }
            return high;  // key not found.
        }
    }

}
