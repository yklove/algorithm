package cn.yklove.leetcode.contest.weekly216;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {

        public int minimumEffort(int[][] tasks) {
            List<Task> taskList = new ArrayList<>();
            for (int[] task : tasks) {
                taskList.add(new Task(task[0], task[1]));
            }
            taskList.sort((o1, o2) -> {
//                int i = o2.max.compareTo(o1.max);
//                if (i != 0) {
//                    return i;
//                }
//                return o1.min.compareTo(o2.min);
                return Integer.compare(o2.max - o2.min, o1.max - o1.min);
            });
            int need = 0;
            int residue = 0;
            for (Task task : taskList) {
                if (residue < task.max) {
                    int i = task.max - residue;
                    need += i;
                    residue += i;
                }
                residue -= task.min;
            }
            return need;
        }

        class Task {
            Integer min;
            Integer max;

            public Task(int min, int max) {
                this.min = min;
                this.max = max;
            }

        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(8, solution.minimumEffort(new int[][]{
                {1, 2}, {2, 4}, {4, 8}
        }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(32, solution.minimumEffort(new int[][]{
                {1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}
        }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(27, solution.minimumEffort(new int[][]{
                {1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}
        }));
    }


}
