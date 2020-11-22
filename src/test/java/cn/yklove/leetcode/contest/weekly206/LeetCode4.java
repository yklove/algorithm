package cn.yklove.leetcode.contest.weekly206;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public boolean isTransformable(String s, String t) {
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            for (int i = 0; i < charsS.length; i++) {
                int tmp = i;
                while (charsS[tmp] != charsT[i]) {
                    tmp++;
                    if (tmp >= charsS.length) {
                        return false;
                    }
                }
                while (tmp != i) {
                    // 交换位置
                    if (tmp - 1 >= 0 && charsS[tmp - 1] > charsS[tmp]) {
                        char tmpChar = charsS[tmp - 1];
                        charsS[tmp - 1] = charsS[tmp];
                        charsS[tmp] = tmpChar;
                        tmp--;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.isTransformable("84532", "34852"));
    }


    @Test
    public void test2() {
        Assert.assertTrue(solution.isTransformable("34521", "23415"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(solution.isTransformable("12345", "12435"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(solution.isTransformable("1", "2"));
    }
}
