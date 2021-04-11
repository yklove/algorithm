package cn.yklove.leetcode.contest.weekly224;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int maxSize = 0;
            int k = 0;
            while (k < matrix.length) {
                List<Integer> size = new ArrayList<>();
                int tmpBreak = matrix.length;
                for (int i = 0; i < matrix[0].length; i++) {
                    int count = 0;
                    for (int j = matrix.length - 1 - k; j >= 0; j--) {
                        if (matrix[j][i] == 1) {
                            count++;
                        } else {
                            tmpBreak = Math.min((matrix.length - 1 - k) - j, tmpBreak);
                            break;
                        }
                    }
                    size.add(count);
                }
                size.sort(Integer::compareTo);
                for (int i = 0; i < size.size(); i++) {
                    maxSize = Math.max(maxSize, size.get(i) * (size.size() - i));
                }
                k += (tmpBreak + 1);
            }
            return maxSize;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(75, solution.largestSubmatrix(new int[][]{{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(75, solution.largestSubmatrix(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 1, 1}, {1, 0, 1}, {0, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 0}, {1, 1, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 1, 0}, {1, 1, 0}}));
    }

}
