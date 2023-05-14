package cn.yklove.leetcode.contest.weekly318;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.value).thenComparingInt(o -> o.index));
            if (candidates * 2 >= costs.length) {
                for (int i = 0; i < costs.length; i++) {
                    priorityQueue.add(new Node(costs[i], i));
                }
                long ans = 0;
                for (int i = 0; i < k; i++) {
                    Node poll = priorityQueue.poll();
                    ans += poll.value;
                }
                return ans;
            }
            int start = candidates;
            for (int i = 0; i < candidates; i++) {
                priorityQueue.add(new Node(costs[i], i));
            }
            int end = costs.length - 1 - candidates;
            for (int i = costs.length - 1; i > end; i--) {
                priorityQueue.add(new Node(costs[i], i));
            }
            long ans = 0;
            for (int i = 0; i < k; i++) {
                Node poll = priorityQueue.poll();
                ans += poll.value;
                int index = poll.index;
                if (index > end && end >=start) {
                    priorityQueue.add(new Node(costs[end], end));
                    end--;
                }
                if (index < start && start <= end) {
                    priorityQueue.add(new Node(costs[start], start));
                    start++;
                }
            }
            return ans;
        }

        class Node {
            int value;
            int index;

            public Node(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.totalCost(new int[]{3, 2, 7, 7, 1, 2}, 2, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(11, solution.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, solution.totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1407, solution.totalCost(new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12));
    }
}
