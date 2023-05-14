package cn.yklove.leetcode.contest.weekly325;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int takeCharacters(String s, int k) {
            char[] chars = s.toCharArray();
            PriorityQueue<Integer>[][] left = new PriorityQueue[6][3];
            PriorityQueue<Integer>[][] right = new PriorityQueue[6][3];
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 3; i++) {
                    left[j][i] = new PriorityQueue<>();
                    right[j][i] = new PriorityQueue<>();
                }
            }
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    a++;
                    for (int j = 0; j < 6; j++) {
                        left[j][0].add(i + 1);
                    }
                } else if (chars[i] == 'b') {
                    b++;
                    for (int j = 0; j < 6; j++) {
                        left[j][1].add(i + 1);
                    }
                } else {
                    c++;
                    for (int j = 0; j < 6; j++) {
                        left[j][2].add(i + 1);
                    }
                }
            }
            if (a < k || b < k || c < k) {
                return -1;
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == 'a') {
                    for (int j = 0; j < 6; j++) {
                        right[j][0].add(chars.length - i);
                    }
                } else if (chars[i] == 'b') {
                    for (int j = 0; j < 6; j++) {
                        right[j][1].add(chars.length - i);
                    }
                } else {
                    for (int j = 0; j < 6; j++) {
                        right[j][2].add(chars.length - i);
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            int[][] aa = new int[][]{
                    {0, 1, 2},
                    {0, 2, 1},
                    {1, 0, 2},
                    {1, 2, 0},
                    {2, 0, 1},
                    {2, 1, 0},
            };
            for (int i = 0; i < aa.length; i++) {
                int[] ints = aa[i];
                int timeLeft = 0;
                int timeRight = 0;
                for (int anInt : ints) {
                    int[] time1 = getTime(k, left[i], right[i], anInt, timeLeft, timeRight);
                    if (time1[0] == -1 && time1[1] == -1) {
                        return -1;
                    }
                    timeLeft = time1[0];
                    timeRight = time1[1];
                }
                ans = Math.min(ans, timeLeft + timeRight);
            }
            return ans;
        }

        private int[] getTime(int k, PriorityQueue<Integer>[] left, PriorityQueue<Integer>[] right, int index, int timeLeft, int timeRight) {
            for (int i = 0; i < k; i++) {
                if (left[index].isEmpty() && right[index].isEmpty()) {
                    return new int[]{-1, -1};
                }
                if (left[index].isEmpty()) {

                } else if (right[index].isEmpty()) {

                } else {
                    // 把小于等于换成小于，结果是不一样的，说明这里有问题
                    if (left[index].peek() - timeLeft <= right[index].peek() - timeRight) {
                        Integer poll = left[index].poll();
                        if (poll > timeLeft) {
                            timeLeft = poll;
                        }
                    } else {
                        Integer poll = right[index].poll();
                        if (poll > timeRight) {
                            timeRight = poll;
                        }
                    }
                }
            }
            return new int[]{timeLeft, timeRight};
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        String s = "123, 123";
        if(s != null){
            String[] split = s.split(",");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("123");
        }
        Assert.assertEquals(8, solution.takeCharacters("aabaaaacaabc", 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.takeCharacters("abca", 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, solution.takeCharacters("cbaabccac", 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(6, solution.takeCharacters("cacaabbccc", 2));
    }

    @Test
    public void test5() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly325/LeetCode2_5.txt"));
        String s = in.nextLine();
        Assert.assertEquals(solution.takeCharacters(s, 32701), 98317);
    }
}
