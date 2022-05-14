package cn.yklove.leetcode.contest.weekly292;

import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int countTexts(String pressedKeys) {
            char[] chars = pressedKeys.toCharArray();
            return (int) (process(chars, 0) % 1000000007);
        }

        private long process(char[] chars, int index) {
            if (index >= chars.length) {
                return 0;
            }
            long count = 0;
            for (int i = index; i < chars.length; i++) {
                if (chars[i] == chars[index]) {
                    count++;
                    count += process(chars, index + 1);
                    count %= 1000000007;
                } else {
                    break;
                }
            }
            return count % 1000000007;
        }
    }

    Solution solution = new Solution();
    @Test
    public void test(){
        Assert.assertEquals(solution.countTexts("22233"),8);
    }

}
