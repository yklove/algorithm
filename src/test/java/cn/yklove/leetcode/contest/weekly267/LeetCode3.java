package cn.yklove.leetcode.contest.weekly267;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            int column = encodedText.length() / rows;
            char[][] chars = new char[rows][column];
            char[] encodedTexts = encodedText.toCharArray();
            for (int i = 0; i < encodedTexts.length; i++) {
                chars[i / column][i % column] = encodedTexts[i];
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (i != column) {
                int tmpI = 0;
                int tmpJ = i;
                while (tmpI < rows && tmpJ < column) {
                    stringBuilder.append(chars[tmpI][tmpJ]);
                    tmpI++;
                    tmpJ++;
                }
                i++;
            }
            while (stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            return stringBuilder.toString();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals("", solution.decodeCiphertext("", 5));
//        Assert.assertEquals("i love leetcode", solution.decodeCiphertext("iveo    eed   l te   olc", 4));
    }

}
