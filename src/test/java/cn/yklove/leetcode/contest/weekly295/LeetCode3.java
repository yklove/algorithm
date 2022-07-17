package cn.yklove.leetcode.contest.weekly295;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int totalSteps(int[] nums) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
                int num = nums[i];
                if (stack.isEmpty()) {
                    stack.add(i);
                    continue;
                }
                if (num < nums[stack.peek()]) {
                    stack.add(i);
                    continue;
                }
                if(num == nums[stack.peek()]){
                    stack.pop();
                    stack.add(i);
                    continue;
                }
                while (!stack.isEmpty() && num > nums[stack.peek()]) {
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer peek = stack.peek();
                        ans = Math.max(ans, pop - peek);
                    }
                }
                stack.add(i);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, solution.totalSteps(new int[]{4, 5, 7, 7, 13}));
    }


    @Test
    public void test3() {
        Assert.assertEquals(6, solution.totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(2, solution.totalSteps(new int[]{5,11,7,8,11}));
    }

}
