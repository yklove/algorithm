package cn.yklove.leetcode.contest.spring2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
    }

    class Solution {
        public int magicTower(int[] nums) {
            long tmp = 1;
            for (int num : nums) {
                tmp+=num;
            }
            if (tmp <= 0) {
                return -1;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            long sum = 1;
            int ans = 0;
            for (int num : nums) {
                if (num < 0) {
                    priorityQueue.add(num);
                    if (sum + num <= 0) {
                        ans++;
                        sum -= priorityQueue.poll();
                    }
                }
                sum += num;
            }
            return ans;
        }
    }

}
