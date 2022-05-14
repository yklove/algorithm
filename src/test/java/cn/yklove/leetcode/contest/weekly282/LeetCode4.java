package cn.yklove.leetcode.contest.weekly282;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
            int ans = 0;
            // 已经跑的圈数
            int index = 0;
            // 假设轮胎跑tmp圈
            for (int tmp = 1; tmp <= numLaps - index; tmp++) {

                // 计算每个轮胎花费的时间
                for (int[] tire : tires) {
                    int time = tire[0] * (int) Math.pow(tire[1], tmp - 1);
                }

            }


            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(21, solution.minimumFinishTime(new int[][]{{2, 3}, {3, 4}}, 5, 4));
    }

    @Test
    public void test2() {
        Assert.assertEquals(25, solution.minimumFinishTime(new int[][]{{1, 10}, {2, 2}, {3, 4}}, 6, 5));
    }

}
