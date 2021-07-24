package cn.yklove.leetcode.contest.biweekly52;

import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            for (int i = 0; i < box.length; i++) {
                char[] row = box[i];
                for (int j = row.length - 1; j >= 0; j--) {
                    if (row[j] == '*') {
                        continue;
                    }
                    int k = j;
                    while (k < row.length - 1) {
                        if (row[k + 1] != '.') {
                            break;
                        }
                        k++;
                    }
                    if (k != j) {
                        row[k] = row[j];
                        row[j] = '.';
                    }
                }
            }
            char[][] endBox = new char[box[0].length][box.length];
            for (int i = 0; i < box.length; i++) {
                char[] row = box[i];
                for (int j = 0; j < row.length; j++) {
                    endBox[j][box.length - i - 1] = row[j];
                }
            }
            return endBox;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}});
    }

}
