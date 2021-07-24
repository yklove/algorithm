package cn.yklove.leetcode.contest.weekly244;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int minFlips(String s) {
            int count = count(s);
            if (count == 0) {
                return 0;
            }
            // 寻找最长的1或者0
            char[] chars = s.toCharArray();
            int max = -1;
            int index = -1;
            char tmp = '2';
            int tmpCount = 1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == tmp) {
                    tmpCount++;
                    continue;
                } else {
                    if (tmpCount > max) {
                        max = tmpCount;
                        index = i - tmpCount;
                    }
                    tmp = chars[i];
                    tmpCount = 1;
                }
            }
            if (tmpCount > max) {
                max = tmpCount;
                index = chars.length - tmpCount;
            }
            // 删除字符串至index
            for (int i = 0; i < index; i++) {
                s = s.substring(1) + s.charAt(0);
            }
            count = Math.min(count, count(s));
            s = s.substring(1) + s.charAt(0);
            count = Math.min(count, count(s));
            return count;
        }

        private int count(String s) {
            char[] chars = s.toCharArray();
            char[] tmp = new char[chars.length];
            tmp[0] = chars[0];
            for (int i = 1; i < tmp.length; i++) {
                if (tmp[i - 1] == '0') {
                    tmp[i] = '1';
                } else {
                    tmp[i] = '0';
                }
            }
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != tmp[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test

    public void test() {
        Assert.assertEquals(7, solution.minFlips("100101011101000001010010110"));
//        Assert.assertEquals(5, solution.minFlips("10001100101000000"));
    }

}
