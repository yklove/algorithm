package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

public class Problem3 {


    /**
     * 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
     * 牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。
     * 牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。 牛牛想知道他最少需要涂染几个正方形。
     * 如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
     */
    class Solution {

        /**
         * 基本过程：假设以i位置进行划分，将左半部分染色成R，右半部分染色成G，所需的次数是左半部分G的数量+右半部分R的数量。
         * <p>
         * 如果发现暴力求解的方法，有遍历原数组的地方，尝试着预处理一下，将遍历优化为查找。
         * <p>
         * 通过预处理数组的方式，将加速暴力求解的过程。
         * <p>
         * *     R G G G R R R G
         * 左侧G 0 1 2 3 3 3 3 4
         * 右侧R 4 3 3 3 3 2 1 0
         * 结果：3 4 4 4 5 3 3 4
         * 如果当前是R的话，左侧G+右侧R-1
         * 如果当前是G的话，左侧G+右侧R
         */
        public int dyeing(char[] arr) {
            int[] leftG = new int[arr.length];
            int[] rightR = new int[arr.length];
            int countG = 0;
            int countR = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'G') {
                    countG++;
                }
                leftG[i] = countG;
                if (arr[arr.length - i - 1] == 'R') {
                    countR++;
                }
                rightR[arr.length - i - 1] = countR;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                ans = Math.min(ans, leftG[i] + rightR[i] + (arr[i] == 'R' ? -1 : 0));
            }
            return ans;
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.dyeing("RGRGR".toCharArray()), 2);
    }
}