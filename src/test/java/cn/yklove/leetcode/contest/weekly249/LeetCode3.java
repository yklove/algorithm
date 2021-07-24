package cn.yklove.leetcode.contest.weekly249;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static void main(String[] args) {
        int x = 5;
        System.out.println(x+x++);
    }

    class Solution {
        public int colorTheGrid(int m, int n) {
            return (int) (process(new int[m][n], 0, 0) % (1000000000 + 7));
        }

        private long process(int[][] arr, int x, int y) {
            int top = getColor(arr, x - 1, y);
            int left = getColor(arr, x, y - 1);
            boolean hong = true;
            boolean lv = true;
            boolean lan = true;
            if (top == 1 || left == 1) {
                hong = false;
            }
            if (top == 2 || left == 2) {
                lv = false;
            }
            if (top == 3 || left == 3) {
                lan = false;
            }
            if (hong) {
                arr[x][y] = 1;
                process(arr, x, y);
            }
            return 0L;
        }

        private int getColor(int[][] arr, int x, int y) {
            if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
                return -1;
            }
            return arr[x][y];
        }
    }

}
