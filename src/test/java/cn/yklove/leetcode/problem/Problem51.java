package cn.yklove.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Problem51 {

    class Solution {
        private List<List<String>> ans;

        public List<List<String>> solveNQueens(int n) {
            ans = new ArrayList<>();
            char[][] arrays = new char[n][n];
            for (char[] arr : arrays) {
                Arrays.fill(arr, '.');
            }
            process(arrays, 0);
            return ans;
        }

        private void process(char[][] arrays, int index) {
            if (index >= arrays.length) {
                List<String> list = new ArrayList<>();
                for (char[] arr : arrays) {
                    list.add(new String(arr));
                }
                ans.add(list);
                return;
            }
            for (int i = 0; i < arrays.length; i++) {
                // 判断当前位置 index i 是否可以放
                if (check(arrays, index, i)) {
                    arrays[index][i] = 'Q';
                    process(arrays, index + 1);
                    arrays[index][i] = '.';
                }
            }
        }

        private boolean check(char[][] arrays, int x, int y) {
            if (arrays[x][y] == 'Q') {
                return false;
            }
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i][y] == 'Q') {
                    return false;
                }
            }
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[x][i] == 'Q') {
                    return false;
                }
            }
            int i = x;
            int j = y;
            for (; i >= 0 && j >= 0; i--, j--) {
                if (arrays[i][j] == 'Q') {
                    return false;
                }
            }
            i = x;
            j = y;
            for (; i < arrays.length && j < arrays.length; i++, j++) {
                if (arrays[i][j] == 'Q') {
                    return false;
                }
            }
            i = x;
            j = y;
            for (; i < arrays.length && j >= 0; i++, j--) {
                if (arrays[i][j] == 'Q') {
                    return false;
                }
            }
            i = x;
            j = y;
            for (; i >= 0 && j < arrays.length; i--, j++) {
                if (arrays[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        List<List<String>> ans = Arrays.asList(Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
        Assert.assertEquals(ans, solution.solveNQueens(4));
    }

}
