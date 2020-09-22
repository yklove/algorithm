package cn.yklove.leetcode.contest.LCCUP20;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode2 {

    /**
     * 秋日市集上，魔术师邀请小扣与他互动。魔术师的道具为分别写有数字 1~N 的 N 张卡牌，然后请小扣思考一个 N 张卡牌的排列 target。
     * <p>
     * 魔术师的目标是找到一个数字 k（k >= 1），使得初始排列顺序为 1~N 的卡牌经过特殊的洗牌方式最终变成小扣所想的排列 target，特殊的洗牌方式为：
     * <p>
     * 第一步，魔术师将当前位于偶数位置的卡牌（下标自 1 开始），保持当前排列顺序放在位于奇数位置的卡牌之前。例如：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]；
     * 第二步，若当前卡牌数量小于等于 k，则魔术师按排列顺序取走全部卡牌；若当前卡牌数量大于 k，则取走前 k 张卡牌，剩余卡牌继续重复这两个步骤，直至所有卡牌全部被取走；
     * 卡牌按照魔术师取走顺序构成的新排列为「魔术取数排列」，请返回是否存在这个数字 k 使得「魔术取数排列」恰好就是 target，从而让小扣感到大吃一惊。
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = [2,4,3,1,5]
     * <p>
     * 输出：true
     * <p>
     * 解释：排列 target 长度为 5，初始排列为：1,2,3,4,5。我们选择 k = 2：
     * 第一次：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]。取走前 2 张卡牌 2,4，剩余 [1,3,5]；
     * 第二次：将当前排列 [1,3,5] 位于偶数位置的 [3] 置于奇数位置的 [1,5] 前，排列变为 [3,1,5]。取走前 2 张 3,1，剩余 [5]；
     * 第三次：当前排列为 [5]，全部取出。
     * 最后，数字按照取出顺序构成的「魔术取数排列」2,4,3,1,5 恰好为 target。
     * <p>
     * 示例 2：
     * <p>
     * 输入：target = [5,4,3,2,1]
     * <p>
     * 输出：false
     * <p>
     * 解释：无法找到一个数字 k 可以使「魔术取数排列」恰好为 target。
     * <p>
     * 提示：
     * <p>
     * 1 <= target.length = N <= 5000
     * 题目保证 target 是 1~N 的一个排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er94lq
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {

        /**
         * 首先对原数组进行一次排序，形成 firstSort 数组.
         * 此时寻找 target 数组与 firstSort 数组的最长公共前缀 k .
         * 可以证明， k 应该是唯一解.
         * 因此接下来模拟题目描述的过程，如果模拟过程中，有任何一步出现了和 target 数组不一致的情况，答案就是false，否则是成立的。
         *
         * @param target
         * @return
         */
        public boolean isMagic(int[] target) {
            int length = target.length;
            int[] firstSort = new int[length];
            int index = 0;
            for (int i = 2; i <= length; i += 2) {
                firstSort[index++] = i;
            }
            for (int i = 1; i <= length; i += 2) {
                firstSort[index++] = i;
            }
            int k = 0;
            for (int i = 0; i < length; i++) {
                if (target[i] == firstSort[i]) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == 0) {
                return false;
            }
            int[] originArr = new int[length];
            for (int i = 0; i < length; i++) {
                originArr[i] = i + 1;
            }
            int[] endArr = new int[length];
            int endIndex = 0;
            while (originArr.length != 0) {
                int[] tmpArr = new int[originArr.length];
                int tmpIndex = 0;
                for (int i = 1; i < originArr.length; i += 2) {
                    tmpArr[tmpIndex++] = originArr[i];
                }
                for (int i = 0; i < originArr.length; i += 2) {
                    tmpArr[tmpIndex++] = originArr[i];
                }
                for (int i = 0; i < k && i < tmpArr.length; i++) {
                    endArr[endIndex++] = tmpArr[i];
                }
                if (!Arrays.equals(Arrays.copyOf(target, endIndex - 1), Arrays.copyOf(endArr, endIndex - 1))) {
                    return false;
                }
                if (k < tmpArr.length) {
                    originArr = Arrays.copyOfRange(tmpArr, k, tmpArr.length);
                } else {
                    originArr = new int[0];
                }
            }
            return true;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.isMagic(new int[]{2, 4, 3, 1, 5}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.isMagic(new int[]{5, 4, 3, 2, 1}));
    }

}
