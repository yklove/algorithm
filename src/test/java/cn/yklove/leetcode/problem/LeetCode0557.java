package cn.yklove.leetcode.problem;

import cn.yklove.leetcode.contest.weekly204.LeetCode2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode0557 {

    /**
     * 557. 反转字符串中的单词 III<p>
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。<p>
     * 示例：<p>
     * 输入："Let's take LeetCode contest"<p>
     * 输出："s'teL ekat edoCteeL tsetnoc"<p>
     * 提示：<p>
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。<p>
     * 来源：力扣（LeetCode）<p>
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii<p>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {

        public String reverseWords(String s) {
            String[] s1 = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s2 : s1) {
                stringBuilder.append(new StringBuffer(s2).reverse()).append(" ");
            }
            return stringBuilder.substring(0, s.length());
        }

        public String reverseWords2(String s) {
            return Arrays.stream(s.split(" ")).map(str -> new StringBuilder(str).reverse()).collect(Collectors.joining(" "));
        }
    }

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        Assert.assertEquals(solution.reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.reverseWords2("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc");
    }


}
