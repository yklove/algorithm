package cn.yklove.leetcode.contest.weekly217;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {

//        public int[] mostCompetitive(int[] nums, int k) {
//            if (nums.length == k) {
//                return nums;
//            }
//            int tmp = nums.length - k;
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
//            LinkedList<Integer> queue = new LinkedList<>();
//            for (int i = tmp; i < nums.length; i++) {
//                priorityQueue.add(nums[i]);
//                queue.add(nums[i]);
//            }
//            for (int i = tmp - 1; i >= 0; i--) {
//                priorityQueue.add(nums[i]);
//                boolean key = true;
//                if (priorityQueue.size() > k && priorityQueue.peek() == nums[i]) {
//                    key = false;
//                }
//                priorityQueue.poll();
//
//                if (key) {
//                    queue.addFirst(nums[i]);
//                    queue.removeLast();
//                }
//            }
//            return null;
//        }

//        public int[] mostCompetitive(int[] nums, int k) {
//            if (nums.length == k) {
//                return nums;
//            }
//            int tmp = nums.length - k;
//            int[] ans = new int[k];
//            for (int i = 0; i < k; i++) {
//                ans[i] = tmp + i;
//            }
//            for (int i = tmp; i < nums.length; i++) {
//                int min = i - tmp - 1 < 0 ? -1 : ans[i - tmp - 1];
//                for (int j = i - 1; j > min; j--) {
//                    if (nums[j] <= nums[ans[i - tmp]]) {
//                        ans[i - tmp] = j;
//                    }
//                }
//            }
//            int[] end = new int[k];
//            for (int i = 0; i < ans.length; i++) {
//                end[i] = nums[ans[i]];
//            }
//            return end;
//        }

        public int[] mostCompetitive(int[] nums, int k) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                while (!stack.isEmpty() && stack.size() + (nums.length - i) > k && stack.peek() > num) {
                    stack.pop();
                }
                if (stack.size() < k) {
                    stack.add(num);
                }
            }
            return stack.stream().mapToInt(Integer::intValue).toArray();
        }
    }


    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 6}, solution.mostCompetitive(new int[]{3, 5, 2, 6}, 2));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{2, 3, 3, 4},
                solution.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{8, 80, 2},
                solution.mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3));
    }

}
