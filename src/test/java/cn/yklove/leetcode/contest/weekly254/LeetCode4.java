package cn.yklove.leetcode.contest.weekly254;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {


            int low = 0;
            int high = cells.length - 1;
            int ans = 0;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int[][] array = new int[row][col];
                for (int i = 0; i < mid; i++) {
                    array[cells[i][0] - 1][cells[i][1] - 1] = 1;
                }
                boolean isArray = isArray(array);
                if (isArray) {
                    low = mid + 1;
                    ans = mid;
                } else
                    high = mid - 1;
            }
            return ans;  // key not found.
        }

        private boolean isArray(int[][] arrays) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (isLink(0, j, arrays)) {
                    return true;
                }
            }
            return false;
        }


        private boolean isLink(int x, int y, int[][] arrays) {
            if (x < 0) {
                return false;
            }
            if (y < 0 || y >= arrays[0].length) {
                return false;
            }
            if (arrays[x][y] != 0) {
                return false;
            }
            if (x == arrays.length - 1) {
                return true;
            }
            arrays[x][y] = 2;
            boolean ans = isLink(x, y + 1, arrays) ||
                    isLink(x, y - 1, arrays) ||
                    isLink(x + 1, y, arrays) ||
                    isLink(x - 1, y, arrays);
            arrays[x][y] = 0;
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        System.out.println(solution.latestDayToCross(2,2,new int[][]{{1,1},{2,1},{1,2},{2,2}}));;
    }
}
