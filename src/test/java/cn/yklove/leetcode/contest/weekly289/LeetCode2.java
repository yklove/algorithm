package cn.yklove.leetcode.contest.weekly289;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {

        private int[] dp;

        public int minimumRounds(int[] tasks) {
            dp = new int[1000000];
            Map<Integer, Integer> map = new HashMap<>();
            for (int task : tasks) {
                if (map.containsKey(task)) {
                    map.put(task, map.get(task) + 1);
                } else {
                    map.put(task, 1);
                }
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int process = process(entry.getValue());
                if (process == Integer.MAX_VALUE) {
                    return -1;
                }
                count += process(entry.getValue());
            }
            return count;
        }

        private int process(int count) {
            if (dp[count] != 0) {
                return dp[count];
            }
            for (int i = count / 3; i >= 0; i--) {
                if ((count - i * 3) % 2 == 0) {
                    dp[count] = i + (count - i * 3) / 2;
                    return i + (count - i * 3) / 2;
                }
            }
            dp[count] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.minimumRounds(new int[]{66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61});
        Assert.assertEquals(i, 20);
    }

}
