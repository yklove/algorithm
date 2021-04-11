package cn.yklove.leetcode.contest.weekly224;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
            char[][] grids = new char[grid.length][grid[0].length()];
            for (int i = 0; i < grid.length; i++) {
                grids[i] = grid[i].toCharArray();
            }
            int mX = 0, mY = 0, cX = 0, cY = 0;
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    if (grids[i][j] == 'M') {
                        mX = i;
                        mY = j;
                        grids[i][j] = '.';
                    }
                    if (grids[i][j] == 'C') {
                        cX = i;
                        cY = j;
                        grids[i][j] = '.';
                    }
                }
            }
            return processM(grids, catJump, mouseJump, mX, mY, cX, cY);
        }

        /**
         * 处理老鼠
         */
        private boolean processM(char[][] grids, int catJump, int mouseJump, int mX, int mY, int cX, int cY) {
            // 和猫同一个位置，返回false
            if (mX == cX && mY == cY) {
                return false;
            }
            if (grids[mX][mY] == 'F') {
                return true;
            }
            // 原地不动
//            boolean process1 = processC(grids, catJump, mouseJump, mX, mY, cX, cY);
//            if (process1) {
//                return false;
//            }

            // 往上
            for (int i = 1; i <= mouseJump && mX - i >= 0; i++) {
                if (grids[mX - i][mY] == '#') {
                    break;
                }
                boolean processLeft = processC(grids, catJump, mouseJump, mX - i, mY, cX, cY);
                if (processLeft) {
                    return false;
                }
            }
            // 往下
            for (int i = 1; i <= mouseJump && mX + i < grids.length; i++) {
                if (grids[mX + i][mY] == '#') {
                    break;
                }
                boolean processRight = processC(grids, catJump, mouseJump, mX + i, mY, cX, cY);
                if (processRight) {
                    return false;
                }
            }
            // 往左
            for (int i = 1; i <= mouseJump && mY - i >= 0; i++) {
                if (grids[mX][mY - i] == '#') {
                    break;
                }
                boolean processTop = processC(grids, catJump, mouseJump, mX, mY - i, cX, cY);
                if (processTop) {
                    return false;
                }
            }
            // 往右
            for (int i = 1; i <= mouseJump && mY + i < grids[0].length; i++) {
                if (grids[mX][mY + i] == '#') {
                    break;
                }
                boolean processRight = processC(grids, catJump, mouseJump, mX, mY + i, cX, cY);
                if (processRight) {
                    return false;
                }
            }
            return true;
        }

        private boolean processC(char[][] grids, int catJump, int mouseJump, int mX, int mY, int cX, int cY) {
            // 和猫同一个位置，返回true
            if (mX == cX && mY == cY) {
                return true;
            }
            if (grids[cX][cY] == 'F') {
                return true;
            }
//            // 原地不动
//            boolean process1 = processM(grids, catJump, mouseJump, mX, mY, cX, cY);
//            if (process1) {
//                return false;
//            }

            // 往上
            for (int i = 1; i <= catJump && cX - i >= 0; i++) {
                if (grids[cX - i][cY] == '#') {
                    break;
                }
                boolean processLeft = processM(grids, catJump, mouseJump, mX, mY, cX - i, cY);
                if (processLeft) {
                    return false;
                }
            }
            // 往下
            for (int i = 1; i <= catJump && cX + i < grids.length; i++) {
                if (grids[cX + i][cY] == '#') {
                    break;
                }
                boolean processRight = processM(grids, catJump, mouseJump, mX, mY, cX + i, cY);
                if (processRight) {
                    return false;
                }
            }
            // 往左
            for (int i = 1; i <= catJump && cY - i >= 0; i++) {
                if (grids[cX][cY - i] == '#') {
                    break;
                }
                boolean processTop = processM(grids, catJump, mouseJump, mX, mY, cX, cY - i);
                if (processTop) {
                    return false;
                }
            }
            // 往右
            for (int i = 1; i <= catJump && cY + i < grids[0].length; i++) {
                if (grids[cX][cY + i] == '#') {
                    break;
                }
                boolean processRight = processM(grids, catJump, mouseJump, mX, mY, cX, cY + i);
                if (processRight) {
                    return false;
                }
            }
            return true;
        }
    }


    Solution solution = new Solution();

    @Test
    public void test1() {
        solution.canMouseWin(new String[]{"####F", "#C...", "M...."}, 1, 2);
    }
}
