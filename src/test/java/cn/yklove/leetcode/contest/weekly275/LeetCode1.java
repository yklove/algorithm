package cn.yklove.leetcode.contest.weekly275;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public boolean checkValid(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                int[] hang = matrix[i];
                int[] tmp = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    tmp[hang[j]] = 1;
                }
                for (int k = 1; k <= n; k++) {
                    if(tmp[k] != 1){
                        return false;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int[] tmp = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    tmp[matrix[j][i]] = 1;
                }
                for (int k = 1; k <= n; k++) {
                    if(tmp[k] != 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertFalse(solution.checkValid(new int[][]{{1,1},{1,1}}));
    }

}
