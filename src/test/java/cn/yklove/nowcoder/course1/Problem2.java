package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

public class Problem2 {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.buyApples(0), 0);
        Assert.assertEquals(solution.buyApples(1), -1);
        Assert.assertEquals(solution.buyApples(2), -1);
        Assert.assertEquals(solution.buyApples(18), 3);
        Assert.assertEquals(solution.buyApples(8), 1);
        Assert.assertEquals(solution.buyApples(6), 1);
        Assert.assertEquals(solution.buyApples(7), -1);
        Assert.assertEquals(solution.buyApples(24), 3);
        Assert.assertEquals(solution.buyApples(28), 4);
        Assert.assertEquals(solution.buyApples(26), 4);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(solution.buyApples(i), solution.buyApples2(i));
        }
    }

    /**
     * 小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个 每袋的包装包装不可拆分。 可是小虎现在只想购买恰好n个苹果，小虎想购买尽
     * 量少的袋数方便携带。 如果不能购买恰好n个苹果，小虎将不会购买。输入一个 整数n，表示小虎想购买的个苹果，返回最小使用多少袋子。 如果无论如何都不
     * 能正好装下，返回-1。
     */
    class Solution {

        /**
         * 常规解
         *
         * @param n 想购买的苹果个数
         * @return 最小使用袋子的个数
         */
        public int buyApples(int n) {
            if (n % 2 != 0) {
                return -1;
            }
            int max = n / 8;
            int x = n - max * 8;
            while (x <= 24) {
                if (x % 6 == 0) {
                    return max + x / 6;
                } else {
                    max--;
                    if (max < 0) {
                        break;
                    }
                    x = n - max * 8;
                }
            }
            return -1;
        }

        /**
         * 打表，通过常规解，打印出答案，寻找规律
         *
         * @param n 想购买的苹果个数
         * @return 最小使用袋子的个数
         */
        public int buyApples2(int n) {
            if (n % 2 != 0) {
                return -1;
            }
            if (n < 18) {
                if (n == 0) {
                    return 0;
                }
                if (n == 6 || n == 8) {
                    return 1;
                }
                if (n == 12 || n == 14 || n == 16) {
                    return 2;
                }
                return -1;
            }
            return (n - 18) / 8 + 3;
        }
    }
}