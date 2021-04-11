package cn.yklove.leetcode.contest.weekly234;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
//        public int reinitializePermutation(int n) {
//            int k = n / 2;
//            int tmp = 0;
//            int tmp2 = 0;
//            for (int i = 1; i < k; i++) {
//                if (i % 2 == 0) {
//                    tmp++;
//                }else{
//                    tmp2++;
//                }
//            }
//            return 1 + tmp * 2 + tmp2;
//        }

        public int reinitializePermutation(int n) {
            int[] perm = new int[n];
            for (int i = 0; i < perm.length; i++) {
                perm[i] = i;
            }
            for (int i : perm) {
                System.out.print(i + " ");
            }
            System.out.println();

            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            for (int i : arr) {
                System.out.print(i + " ");
            }
            return 0;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.reinitializePermutation(12);
    }

}
