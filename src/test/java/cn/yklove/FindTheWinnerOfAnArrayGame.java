package cn.yklove;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划
// 👍 724 👎 0
public class FindTheWinnerOfAnArrayGame {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        Assert.assertEquals(solution.getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2), 5);
        Assert.assertEquals(solution.getWinner(new int[]{3, 2, 1}, 10), 3);
        Assert.assertEquals(solution.getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000), 99);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getWinner(int[] arr, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i : arr) {
                list.add(i);
            }
            if (k >= arr.length) {
                list.sort(Integer::compareTo);
                return list.getLast();
            }
            int count = 0;
            int tmp = arr[0];
            while (count < k) {
                int tmpA = list.getFirst();
                list.removeFirst();
                int tmpB = list.getFirst();
                if (tmpA > tmpB) {
                    list.removeFirst();
                    list.addLast(tmpB);
                    list.addFirst(tmpA);
                    if (tmp == tmpA) {
                        count++;
                    } else {
                        tmp = tmpA;
                        count = 1;
                    }
                } else {
                    list.addLast(tmpA);
                    if (tmp == tmpB) {
                        count++;
                    } else {
                        tmp = tmpB;
                        count = 1;
                    }
                }
            }
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
