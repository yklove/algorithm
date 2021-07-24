package cn.yklove.leetcode.contest.weekly242;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {

        public boolean canReach(String s, int minJump, int maxJump) {
            char[] chars = s.toCharArray();
            boolean[] ans = new boolean[s.length()];
            if (chars[s.length() - 1] != '0') {
                return false;
            }
            ans[s.length() - 1] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s.length() - 1);
            for (int i = ans.length - 2; i >= 0; i--) {
                if (!queue.isEmpty() && queue.peek() > Math.min(i + maxJump, s.length() - 1)) {
                    queue.poll();
                }
                if (chars[i] != '0') {
                    continue;
                }
                if (!queue.isEmpty() && queue.peek() >= i + minJump && queue.peek() <= Math.min(i + maxJump, s.length() - 1)) {
                    ans[i] = true;
                    queue.add(i);
                }
            }
            return ans[0];
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertFalse(solution.canReach("01101110", 2, 3));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.canReach("01", 1, 1));
    }
}
