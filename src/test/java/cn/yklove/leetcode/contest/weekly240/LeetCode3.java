package cn.yklove.leetcode.contest.weekly240;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int maxSumMinProduct(int[] nums) {
            long[] dp = new long[nums.length + 1];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }

            int[][] res = new int[nums.length][2];
            Stack<List<Integer>> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack.empty() && nums[stack.peek().get(0)] > nums[i]) {
                    List<Integer> popIndex = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                    for (Integer index : popIndex) {
                        res[index][0] = left;
                        res[index][1] = i;
                    }
                }
                if (!stack.isEmpty() && nums[stack.peek().get(0)] == nums[i]) {
                    stack.peek().add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    stack.push(list);
                }
            }
            while (!stack.empty()) {
                List<Integer> popIndex = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer index : popIndex) {
                    res[index][0] = left;
                    res[index][1] = -1;
                }
            }
            long ans = 0L;
            for (int i = 0; i < nums.length; i++) {
                int left = res[i][0];
                int right = res[i][1];
                if (right == -1) {
                    right = nums.length - 1;
                }else{
                    right = right - 1;
                }
                long sum;
                if (left == -1) {
                    sum = dp[right];
                } else {
                    sum = dp[right] - dp[left];
                }
                ans = Math.max(nums[i] * sum, ans);
            }
            return (int) (ans % (1000000000 + 7));
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        System.out.println(solution.maxSumMinProduct(new int[]{1, 2, 3, 2}));
//        solution.maxSumMinProduct(new int[]{1, 1, 3, 2, 2, 2, 1, 5, 1, 5});

    }

}
