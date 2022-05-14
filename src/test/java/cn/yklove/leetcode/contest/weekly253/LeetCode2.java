package cn.yklove.leetcode.contest.weekly253;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int pile : piles) {
                priorityQueue.add(pile);
            }
            for (int i = 0; i < k; i++) {
                Integer poll = priorityQueue.poll();
                priorityQueue.add(poll - poll / 2);
            }
            int sum = 0;
            while (!priorityQueue.isEmpty()) {
                sum += priorityQueue.poll();
            }
            return sum;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(12, solution.minStoneSum(new int[]{5, 4, 9}, 2));
    }


}
