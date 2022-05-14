package cn.yklove.leetcode.contest.weekly251;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int[][] grade = new int[students.length][students.length];
            for (int i = 0; i < students.length; i++) {
                for (int j = 0; j < mentors.length; j++) {
                    int sum = 0;
                    for (int k = 0; k < students[i].length; k++) {
                        sum += (students[i][k] == mentors[j][k] ? 1 : 0);
                    }
                    grade[i][j] = sum;
                }
            }
            return process(grade, 0, new HashSet<>());
        }

        private int process(int[][] grade, int index, Set<Integer> set) {
            if (index >= grade.length) {
                return 0;
            }
            int[] a = grade[index];
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                if(set.contains(i)){
                    continue;
                }
                int sum = grade[index][i];
                set.add(i);
                sum += process(grade, index + 1, set);
                set.remove(i);
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(8, solution.maxCompatibilitySum(
                new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}},
                new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(10, solution.maxCompatibilitySum(
                new int[][]{{0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 0}},
                new int[][]{{1, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 1}}));
    }

}
