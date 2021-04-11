package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

public class Problem5 {

    /**
     * 牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。 最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。
     * 在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。
     * 不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游 戏,请输出胜利者的名字。
     */
    class Solution {

        /**
         * n的数量小于5份时，可以直接输出答案； 如果n的数量大于5分数，枚举能吃的草的数量，将剩下的草的数量作为n传递到子过程中。
         * 主过程的先手，和子过程的后手实际上是同一个人，所以当子过程的后手赢了，代表主过程的先手赢了。
         *
         * @param n
         * @return
         */
        public String graze(int n) {
            if (n < 5) {
                return n == 2 || n == 0 ? "后手" : "先手";
            }
            int base = 1;
            while (base <= n) {
                if (graze(n - base).equals("后手")) {
                    return "先手";
                }
                base *= 4;
            }
            return "后手";
        }

        /**
         * 通过打表的方式寻找到的规律
         */
        public String graze2(int n) {
            n %= 5;
            return n == 2 || n == 0 ? "后手" : "先手";
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ":" + solution.graze(i));
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 50; i++) {
            Assert.assertEquals(solution.graze(i), solution.graze2(i));
        }
    }

}