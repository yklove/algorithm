package cn.yklove.leetcode.contest.weekly253;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int minSwaps(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
            return (int) Math.ceil(stack.size() / 2.0 / 2.0);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.minSwaps("][]["));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, solution.minSwaps("]]][[["));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, solution.minSwaps("[]"));
    }
}
