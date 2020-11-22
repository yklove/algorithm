package cn.yklove.leetcode.contest.weekly206;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            // 分数表
            int[][] score = new int[n][n];
            for (int i = 0; i < preferences.length; i++) {
                for (int j = 0; j < preferences[i].length; j++) {
                    score[i][preferences[i][j]] = j;
                }
            }
            // 配对表
            int[] pair = new int[n];
            for (int i = 0; i < pairs.length; i++) {
                pair[pairs[i][0]] = pairs[i][1];
                pair[pairs[i][1]] = pairs[i][0];
            }
            Set<Integer> set = new HashSet<>();
            for (int x = 0; x < n; x++) {
                for (int u = 0; u < n; u++) {
                    if (x == u) {
                        continue;
                    }
                    int y = pair[x];
                    int v = pair[u];
                    if (score[x][u] < score[x][y] && score[u][x] < score[u][v]) {
                        set.add(x);
                    }
                }
            }
            return set.size();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.unhappyFriends(4, new int[][]{
                {1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}
        }, new int[][]{
                {0, 1}, {2, 3}
        }));
    }

}
