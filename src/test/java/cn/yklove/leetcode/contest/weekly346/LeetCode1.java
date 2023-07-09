package cn.yklove.leetcode.contest.weekly346;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int minLength(String s) {
            if(s.length() == 1){
                return 1;
            }
            char[] charArray = s.toCharArray();
            char[] newChar = new char[s.length()];
            int oldLength = charArray.length;
            int length;
            while (true) {
                length = 0;
                if(oldLength == 1){
                    return 1;
                }
                for (int i = 0; i < oldLength - 1; ) {
                    if (charArray[i] == 'A' && charArray[i + 1] == 'B' || charArray[i] == 'C' && charArray[i + 1] == 'D') {
                        i += 2;
                        if (i == oldLength - 1) {
                            newChar[length] = charArray[i];
                            length++;
                            i++;
                        }
                        continue;
                    } else {
                        newChar[length] = charArray[i];
                        length++;
                        i++;
                        if (i == oldLength - 1) {
                            newChar[length] = charArray[i];
                            length++;
                            i++;
                        }
                    }
                }
                if (length == oldLength) {
                    break;
                }
                charArray = newChar;
                oldLength = length;
            }
            return length;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(2, solution.minLength("ABFCACDB"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, solution.minLength("ACBBD"));
    }
    @Test
    public void test3() {
        Assert.assertEquals(1, solution.minLength("A"));
    }
    @Test
    public void test4() {
        Assert.assertEquals(1, solution.minLength("ABG"));
    }


}
