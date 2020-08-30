package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiangla
 */
public class Problem1 {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        Assert.assertEquals(solution.aPointCoveredByARope(new int[]{0, 1, 3, 4, 5, 6, 7, 10}, 4), 5);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.aPointCoveredByARope2(new int[]{0, 1, 3, 4, 5, 6, 7, 10}, 4), 5);
    }

    /**
     * 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n-1]，
     * 给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
     */
    class Solution {

        /**
         * 以遍历到的点作为绳子的末位点，则起始点应该是当前遍历到的点-绳子长度。
         * 所以接下来二分查找绳子的起始点，找到起始点的位置，两者相减可以算出覆盖的点的数量。
         * 遍历 + 二分
         * n * log(n)
         *
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

        /**
         * 双指针。
         * 如果end和start的长度小于theRopeLength，end继续增加。
         * 否则start增加。
         * 算法复杂度O(n)
         */
        public int aPointCoveredByARope2(int[] point, int theRopeLength) {
            int start = 0;
            int end = 0;
            int max = 0;
            while (end < point.length) {
                if (point[end] - point[start] <= theRopeLength) {
                    max = Math.max(end - start + 1, max);
                    end++;
                } else {
                    start++;
                }
            }
            return max;
        }

    }

}