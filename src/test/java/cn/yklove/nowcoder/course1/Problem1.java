package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiangla
 */
public class Problem1 {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.aPointCoveredByARope(new int[]{0, 1, 3, 4, 5, 6, 7, 10}, 4), 5);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    /**
     * 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n-1]，
     * 给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
     */
    class Solution {

        /**
         * @param point         绳子上的点
         * @param theRopeLength 绳子长度
         * @return
         */
        public int aPointCoveredByARope(int[] point, int theRopeLength) {
            int max = 0;
            for (int endIndex = 0; endIndex < point.length; endIndex++) {
                int endNumber = point[endIndex];
                int startNumber = endNumber - theRopeLength;
                if (startNumber <= 0) {
                    max = Math.max(max, endIndex + 1);
                } else {
                    int startIndex = Math.abs(Arrays.binarySearch(point, startNumber));
                    max = Math.max(max, endIndex - startIndex + 1);
                }
            }
            return max;
        }

    }

}