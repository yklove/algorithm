package cn.yklove.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class Problem59_1 {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertTrue(Arrays.equals(solution.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3),
                new int[] { 3, 3, 5, 5, 6, 7 }));
        Assert.assertTrue(Arrays.equals(solution.maxSlidingWindow(new int[] { 1, -1 }, 1), new int[] { 1, -1 }));
        Assert.assertTrue(
                Arrays.equals(solution.maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3), new int[] { 3, 3, 2, 5 }));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 0 || nums.length == 0) {
                return new int[0];
            }
            int[] ansArr = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                if (i >= k - 1) {
                    ansArr[i - k + 1] = nums[deque.peek()];
                }
            }
            return ansArr;
        }
    }

}