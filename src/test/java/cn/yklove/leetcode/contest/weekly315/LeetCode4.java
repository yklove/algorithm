package cn.yklove.leetcode.contest.weekly315;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long end = 0L;
            for (int k = 1; k <= nums.length; k++) {
                int n = nums.length;
                Deque<Integer> deque = new LinkedList<>();
                Deque<Integer> deque2 = new LinkedList<>();
                for (int i = 0; i < k; ++i) {
                    while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(i);
                    while (!deque2.isEmpty() && nums[i] <= nums[deque2.peekLast()]) {
                        deque2.pollLast();
                    }
                    deque2.offerLast(i);
                }
                if (nums[deque.peekFirst()] == maxK && nums[deque2.peekFirst()] == minK) {
                    end++;
                }
                for (int i = k; i < n; ++i) {
                    while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(i);
                    while (deque.peekFirst() <= i - k) {
                        deque.pollFirst();
                    }

                    while (!deque2.isEmpty() && nums[i] <= nums[deque2.peekLast()]) {
                        deque2.pollLast();
                    }
                    deque2.offerLast(i);
                    while (deque2.peekFirst() <= i - k) {
                        deque2.pollFirst();
                    }
                    if (nums[deque.peekFirst()] == maxK && nums[deque2.peekFirst()] == minK) {
                        end++;
                    }
                }
            }
            return end;
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2,solution.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
    }

}
