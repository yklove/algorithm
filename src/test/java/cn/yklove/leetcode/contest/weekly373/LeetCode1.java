package cn.yklove.leetcode.contest.weekly373;

import org.junit.Assert;
import org.junit.Test;


public class LeetCode1 {

    /**
     * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。
     * 请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
     * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
     */
    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            for (int[] arr : mat) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != arr[(i + k) % arr.length]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    Solution soulution = new Solution();

    @Test
    public void test1(){
        Assert.assertTrue(soulution.areSimilar(new int[][]{
            {1,2,1,2},
            {5,5,5,5},
            {6,3,6,3}
        }, 2));
    }


    @Test
    public void test2(){
        Assert.assertTrue(soulution.areSimilar(new int[][]{
            {2,2},
            {2,2}
        }, 3));
    }


    @Test
    public void test3(){
        Assert.assertFalse(soulution.areSimilar(new int[][]{
            {1,2}
        }, 1));
    }
}
