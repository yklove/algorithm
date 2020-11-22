package cn.yklove.leetcode.contest.weekly216;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {

        public int waysToMakeFair(int[] nums) {
            if (nums.length < 3) {
                if (nums.length == 1) {
                    return 1;
                }
                if (nums[0] == nums[1]) {
                    return 2;
                }
                return 0;
            }
            // 奇数
            int[] oddNumber = new int[nums.length];
            // 偶数
            int[] evenNumber = new int[nums.length];

            evenNumber[0] = nums[0];
            evenNumber[1] = nums[0];
            oddNumber[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                if (i % 2 == 0) {
                    evenNumber[i] = (evenNumber[i - 2] + nums[i]);
                    oddNumber[i] = (oddNumber[i - 1]);
                } else {
                    oddNumber[i] = (oddNumber[i - 2] + nums[i]);
                    evenNumber[i] = (evenNumber[i - 1]);
                }
            }
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if ((oddNumber[nums.length - 1] - oddNumber[0]) == (evenNumber[nums.length - 1] - evenNumber[0])) {
                        ans++;
                    }
                } else if (i != nums.length - 1) {
                    if ((oddNumber[i - 1] + (evenNumber[nums.length - 1] - evenNumber[i])) == (evenNumber[i - 1] + (oddNumber[nums.length - 1] - oddNumber[i]))) {
                        ans++;
                    }
                } else {
                    if (oddNumber[nums.length - 2] == evenNumber[nums.length - 2]) {
                        ans++;
                    }
                }
            }
            return ans;
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.waysToMakeFair(new int[]{2, 1, 6, 4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.waysToMakeFair(new int[]{1, 1, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, solution.waysToMakeFair(new int[]{1, 2, 3}));
    }
}
