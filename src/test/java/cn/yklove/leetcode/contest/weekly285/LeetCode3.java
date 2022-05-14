package cn.yklove.leetcode.contest.weekly285;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
            Info[] infos = process(aliceArrows, 0, numArrows);
            int[] ans = new int[12];
            int count = 0;
            for (int i = 0; i < infos.length - 1; i++) {
                ans[i] = infos[i] != null ? infos[i].count : 0;
                count += ans[i];
            }
            ans[0] = numArrows - count;
            return ans;
        }

        private Info[] process(int[] aliceArrows, int index, int numArrows) {
            Info[] infos = new Info[13];
            if (index > 11) {
                infos[index] = new Info(0, 0, index);
                return infos;
            }
            Info[] list1 = process(aliceArrows, index + 1, numArrows);
            Info[] list2 = (numArrows - aliceArrows[index] - 1) >= 0 ? process(aliceArrows, index + 1, numArrows - aliceArrows[index] - 1) : new Info[13];
            int x = list1[index + 1] != null ? list1[index + 1].score : 0;
            int y = list2[index + 1] != null ? index + list2[index + 1].score : 0;
            if (x >= y) {
                list1[index] = new Info(x, 0, index);
                return list1;
            }
            list2[index] = new Info(y, aliceArrows[index] + 1, index);
            return list2;
        }

        class Info {
            int score;
            int count;
            int index;

            public Info(int score, int count, int index) {
                this.score = score;
                this.count = count;
                this.index = index;
            }
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        solution.maximumBobPoints(89, new int[]{3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5});
    }

}
