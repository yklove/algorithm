package cn.yklove.leetcode.contest.weekly231;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    static class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long difference = Math.abs(goal - sum);
            return (int) (difference / limit + (difference % limit == 0 ? 0 : 1));
        }
    }


    public Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.minElements(new int[]{1, -1, 1}, 3, -4));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<Integer> collect = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int i = in.nextInt();
        int j = in.nextInt();
        int[] aaa = new int[collect.size()];
        for (int i1 = 0; i1 < collect.size(); i1++) {
            aaa[i1] = collect.get(i1);
        }
        Assert.assertEquals(101000, solution.minElements(aaa, i, j));

    }
}
