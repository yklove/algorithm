package cn.yklove.leetcode.contest.test1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public boolean isMagic(int[] target) {
            if (target.length == 1) {
                return true;
            }
            if (target[0] != 2) {
                return false;
            }
            int minK = 1;
            for (int i = 1; i < target.length - 1; i++) {
                if (target[i] == target[i - 1] + 2) {
                    minK++;
                } else {
                    break;
                }
            }
            for (int k = target.length; k >= minK; k--) {
                LinkedList<Integer> original = new LinkedList<>();
                for (int i = 1; i <= target.length; i++) {
                    original.add(i);
                }
                LinkedList<Integer> linkedList = new LinkedList<>();
                while (original.size() != 0) {
                    LinkedList<Integer> tmp = new LinkedList<>();
                    for (int i = 1; i <= original.size(); i++) {
                        if (i % 2 == 0) {
                            tmp.add(original.get(i - 1));
                        }
                    }
                    for (int i = 1; i <= original.size(); i++) {
                        if (i % 2 == 1) {
                            tmp.add(original.get(i - 1));
                        }
                    }
                    for (int i = 0; i < k && i < tmp.size(); i++) {
                        linkedList.add(tmp.get(i));
                    }
                    for (int i = 0; i < k && tmp.size() > 0; i++) {
                        tmp.removeFirst();
                    }
                    original = tmp;
                }
                int[] end = new int[target.length];
                for (int i = 0; i < linkedList.size(); i++) {
                    end[i] = linkedList.get(i);
                }
                boolean equals = Arrays.equals(target, end);
                if (equals) {
                    return equals;
                }
            }
            return false;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.isMagic(new int[]{2, 4, 3, 1, 5}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.isMagic(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(solution.isMagic(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test5() {
        Assert.assertTrue(solution.isMagic(new int[]{2, 1, 3}));
    }

    @Test
    public void test6() {
        Assert.assertTrue(solution.isMagic(new int[]{2, 1, 3, 4}));
    }

    @Test
    public void test4() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
//                long start = System.currentTimeMillis();
//                Assert.assertTrue(solution.isMagic(mock(i, j)));
//                System.out.println(System.currentTimeMillis() - start);
                System.out.println(Arrays.toString(mock(i, j)));
            }
        }
    }

    private int[] mock(int n, int k) {
        LinkedList<Integer> original = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            original.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (original.size() != 0) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 1; i <= original.size(); i++) {
                if (i % 2 == 0) {
                    tmp.add(original.get(i - 1));
                }
            }
            for (int i = 1; i <= original.size(); i++) {
                if (i % 2 == 1) {
                    tmp.add(original.get(i - 1));
                }
            }
            for (int i = 0; i < k && i < tmp.size(); i++) {
                linkedList.add(tmp.get(i));
            }
            for (int i = 0; i < k && tmp.size() > 0; i++) {
                tmp.removeFirst();
            }
            original = tmp;
        }
        int[] end = new int[n];
        for (int i = 0; i < linkedList.size(); i++) {
            end[i] = linkedList.get(i);
        }
        return end;
    }
}
