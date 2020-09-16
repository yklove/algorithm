package cn.yklove.nowcoder.course2;

import org.junit.Assert;
import org.junit.Test;

public class Problem5 {

    /**
     * 一个合法的括号匹配序列有以下定义: </br>
     * 1.空串""是一个合法的括号匹配序列</br>
     * 2.如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列</br>
     * 3.如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列</br>
     * 4.每个合法的括号序列都可以由以上规则生成。 </br>
     * 例如: "","()","()()","((()))"都是合法的括号序列</br>
     * 对于一个合法的括号序列我们又有以下定义它的深度: </br>
     * 1.空串""的深度是0</br>
     * 2.如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为 max(x,y)</br>
     * 3.如果"X"的深度是x,那么字符串"(X)"的深度是x+1</br>
     * 例如: "()()()"的深度是1,"((()))"的深度是3。</br>
     * 牛牛现在给你一个合法的括号序列,需要你计算出其深度。
     */
    public class Solution {

        public int maximumDepthOfBracket(String str) {
            char[] chars = str.toCharArray();
            int ans = 0;
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    count++;
                } else {
                    count--;
                }
                ans = Math.max(count, ans);
            }
            return ans;
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.maximumDepthOfBracket("((()))()"));
    }

}