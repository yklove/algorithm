package cn.yklove.leetcode.problem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qinggeng
 */
public class LeetCode0215 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                priorityQueue.add(num);
                if(priorityQueue.size() > k){
//                    priorityQueue
                }
            }
            return 0;
        }
    }

}
