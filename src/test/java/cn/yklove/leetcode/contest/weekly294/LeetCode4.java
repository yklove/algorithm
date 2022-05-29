package cn.yklove.leetcode.contest.weekly294;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        private static final long mod = 1000000007;

        public int totalStrength(int[] strength) {
            long ans = 0;
            for (int i = 0; i < strength.length; i++) {
                long min = strength[i];
                long sum = strength[i];
                ans = (((min * sum) % mod) + ans) % mod;
                for (int j = i + 1; j < strength.length; j++) {
                    sum += strength[j];
                    min = Math.min(min, strength[j]);
                    ans = (((min * sum) % mod) + ans) % mod;
                }
            }
            return (int) (ans % mod);
        }

        public int totalStrength2(int[] strength) {
            Deque<Integer> tmpDeque = new LinkedList<>();
            int tmpSum = 0;
            long ans = 0;
            // 连续的数量
            for (int i = 1; i <= strength.length; i++) {
                // 计算初始值
                long min = 0;
                long sum = 0;
                tmpSum += strength[i - 1];
                while (!tmpDeque.isEmpty() && strength[i - 1] <= strength[tmpDeque.peekLast()]) {
                    tmpDeque.pollLast();
                }
                tmpDeque.offerLast(i - 1);
                sum = tmpSum;
                Deque<Integer> deque = new LinkedList<>(tmpDeque);
                min = strength[deque.peekFirst()];
                // 首次计算
                ans = (((min * sum) % mod) + ans) % mod;
                // 遍历计算后续窗口
                for (int j = i; j < strength.length; j++) {
                    sum -= strength[j - i];
                    sum += strength[j];
                    while (!deque.isEmpty() && strength[j] <= strength[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(j);
                    while (deque.peekFirst() <= j - i) {
                        deque.pollFirst();
                    }
                    min = strength[deque.peekFirst()];
                    ans = (((min * sum) % mod) + ans) % mod;
                }
            }
            return (int) (ans % mod);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.totalStrength(new int[]{1, 3, 1, 2}), 44);
    }

    @Test
    public void test2() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly294/LeetCode4-test2.txt"));
        String s = in.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split(",");
        System.out.println(split.length);
        int[] tmp = new int[split.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = Integer.parseInt(split[i]);
        }
        long l = System.currentTimeMillis();
        Assert.assertEquals(solution.totalStrength(tmp), 744587013);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly294/LeetCode4-test3.txt"));
        String s = in.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split(",");
        System.out.println(split.length);
        int[] tmp = new int[split.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = Integer.parseInt(split[i]);
        }
        long l = System.currentTimeMillis();
        Assert.assertEquals(solution.totalStrength(tmp), 527398151);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void test4() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly294/LeetCode4-test4.txt"));
        String s = in.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split(",");
        System.out.println(split.length);
        int[] tmp = new int[split.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = Integer.parseInt(split[i]);
        }
        long l = System.currentTimeMillis();
        Assert.assertEquals(solution.totalStrength(tmp), 121473332);
        System.out.println(System.currentTimeMillis() - l);
    }

}
