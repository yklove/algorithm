package cn.yklove.leetcode.contest.weekly222;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    static class Solution {

        public int waysToSplit(int[] nums) {

            int sum = IntStream.of(nums).sum();
            long ans = 0;
            int rightSum = 0;
            for (int i = nums.length - 1; i > 1; i--) {
                rightSum += nums[i];
                if (rightSum < sum / 3.0) {
                    continue;
                }
                int midSum = 0;
                for (int j = i - 1; j >= 1; j--) {
                    midSum += nums[j];
                    if (midSum < (sum - rightSum) / 2.0) {
                        continue;
                    }
                    if (midSum > rightSum) {
                        break;
                    }
                    int leftSum = sum - rightSum - midSum;
                    if (leftSum <= midSum && midSum <= rightSum) {
                        ans += 1;
                        ans %= (1000000000 + 7);
                    }
                }
            }
            return (int) ans;
        }


//        public int waysToSplit(int[] nums) {
//            int sum = IntStream.of(nums).sum();
//
//            // 左半边和
//            int leftSum = 0;
//            int midSum;
//            int rightSum;
//            long ans = 0;
//            // 第一个分隔点
//            for (int i = 0; i < nums.length; i++) {
//                // 分隔点移动时
//                leftSum += nums[i];
//                midSum = 0;
//                // 第二个分隔点
//                for (int j = i + 1; j < nums.length; j++) {
//                    midSum += nums[j];
//                    rightSum = sum - leftSum - midSum;
//                    if (leftSum <= midSum && midSum <= rightSum) {
//                        ans++;
//                        ans %= (1000000000 + 7);
//                    } else {
//                        if (leftSum > sum / 3) {
//                            return (int) ans;
//                        }
//                        if (midSum > (sum - leftSum) / 2) {
//                            break;
//                        }
//                    }
//                }
//            }
//
//            return (int) ans;
//        }
    }

    Solution solution = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(1, solution.waysToSplit(new int[]{1, 1, 1}));
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution.waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        long start = System.currentTimeMillis();
        System.out.println(new Solution().waysToSplit(ints));
        System.out.println(System.currentTimeMillis() - start);
    }
}
