package cn.yklove.nowcoder.course1;

import org.junit.Assert;
import org.junit.Test;

public class Problem7 {

    /**
     * 一个完整的括号字符串定义规则如下: 1空字符串是完整的。 2如果s是完整的字符串，那么(s)也是完整的。
     * 3如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(",
     * "()(" 和 ")" 是不完整的括号字符串。 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化
     * 为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
     */
    class Solution {

        /**
         * 用一个变量count，遇到左括号，count++，遇到右括号，count--。 当count<0的时候，代表左括号缺了，需要加一个左括号。
         * 当最后count>0的时候，说明左括号多了，需要加右括号。
         */
        public int parenthesisMatching(String str) {
            char[] chars = str.toCharArray();
            int count = 0;
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    count++;
                } else if (chars[i] == ')') {
                    count--;
                    if (count < 0) {
                        count = 0;
                        ans++;
                    }
                }
            }
            ans += count;
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.parenthesisMatching("((()))"), 0);
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.parenthesisMatching("((())))"), 1);
    }
}