package cn.yklove.leetcode.contest.weekly224;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            int max = 0;
            int maxCount = 0;
            for (int[] rectangle : rectangles) {
                int tmpMax = Math.min(rectangle[0], rectangle[1]);
                if (tmpMax > max) {
                    maxCount = 1;
                    max = tmpMax;
                } else if (tmpMax == max) {
                    maxCount++;
                }
            }
            return maxCount;
        }
    }

}
