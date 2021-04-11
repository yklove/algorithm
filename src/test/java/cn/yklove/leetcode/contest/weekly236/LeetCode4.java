package cn.yklove.leetcode.contest.weekly236;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {


    @Test
    public void test() {
        MKAverage mkAverage = new MKAverage(3, 1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        Assert.assertEquals(-1, mkAverage.calculateMKAverage());
        mkAverage.addElement(10);
        Assert.assertEquals(3, mkAverage.calculateMKAverage());
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        Assert.assertEquals(5, mkAverage.calculateMKAverage());
    }

    @Test
    public void test2() {
        MKAverage mkAverage = new MKAverage(6, 1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        mkAverage.addElement(12);
        mkAverage.addElement(5);
        mkAverage.addElement(3);
        mkAverage.addElement(4);
        Assert.assertEquals(3, mkAverage.calculateMKAverage());
    }

    class MKAverage {

        private int m;
        private int k;
        private List<Integer> list;
        private Queue<Integer> maxQueue = new LinkedList<>();
        private Queue<Integer> minQueue = new LinkedList<>();
        int count;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            this.list = new ArrayList<>();
            maxQueue = new LinkedList<>();
            minQueue = new LinkedList<>();
            count = 0;
        }

        public void addElement(int num) {
            list.add(num);
            if (maxQueue.size() == 0) {
                maxQueue.add(count);
            } else {
                Integer peek = maxQueue.peek();
//                if(peek <= )
            }
            count++;
        }

        public int calculateMKAverage() {
            if (list.size() < m) {
                return -1;
            }
            PriorityQueue<Integer> priorityQueueX = new PriorityQueue<>();
            long sum = 0;
            for (int i = list.size() - m; i < list.size(); i++) {
                priorityQueueX.add(list.get(i));
            }
            for (int i = 0; i < k; i++) {
                priorityQueueX.poll();
            }
            for (int i = 0; i < m - 2 * k; i++) {
                sum += priorityQueueX.poll();
            }
            return (int) (sum / (m - k * 2));
        }
    }

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */

}
