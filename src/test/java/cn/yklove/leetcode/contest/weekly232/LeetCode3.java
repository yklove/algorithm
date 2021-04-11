package cn.yklove.leetcode.contest.weekly232;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            // 尽可能安排在人数少的班级且不等于1的班级
            PriorityQueue<ClassAndGrade> priorityQueue = new PriorityQueue<>((o1, o2) -> Double.compare(
                    (double) (o2.pass + 1) / (double) (o2.total + 1) - (double) o2.pass / (double) o2.total,
                    (double) (o1.pass + 1) / (double) (o1.total + 1) - (double) o1.pass / (double) o1.total
            ));
            for (int[] aClass : classes) {
                ClassAndGrade classAndGrade = new ClassAndGrade();
                classAndGrade.pass = aClass[0];
                classAndGrade.total = aClass[1];
                priorityQueue.add(classAndGrade);
            }
            while (extraStudents != 0) {
                ClassAndGrade o1 = priorityQueue.poll();
                int max = 1;
                o1.pass += max;
                o1.total += max;
                extraStudents -= max;
                priorityQueue.add(o1);
            }
            List<Double> doubleList = new ArrayList<>();
            for (ClassAndGrade classAndGrade : priorityQueue) {
                doubleList.add((double) (classAndGrade.pass) / (double) (classAndGrade.total));
            }
            return doubleList.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        }

        class ClassAndGrade {
            int total;
            int pass;

            @Override
            public String toString() {
                return "ClassAndGrade{" +
                        "total=" + total +
                        ", pass=" + pass +
                        '}';
            }
        }
    }


    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(0.78333, solution.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2), 0.00001);
    }

    @Test
    public void test2() {
        Assert.assertEquals(0.53485, solution.maxAverageRatio(
                new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4), 0.00001);
    }

    @Test
    public void test3() {
        Assert.assertEquals(0.61455, solution.maxAverageRatio(
                new int[][]{{13609, 17094}, {24079, 89827}}, 22159), 0.00001);
    }
}
