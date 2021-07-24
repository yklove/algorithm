package cn.yklove.leetcode.contest.biweekly54;

import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int minOperationsToFlip(String expression) {
            return 0;
        }

        private int evaluation(String expression) {
            char[] chars = expression.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char aChar : chars) {
                if (aChar == '1' || aChar == '0') {
                    if (!stack.isEmpty() && stack.peek() != '(') {
                        Character pop = stack.pop();
                        Character pop2 = stack.pop();
                        int tmp = pop2 - '0';
                        int tmp2 = aChar - '0';
                        if (pop == '&') {
                            stack.add((char) (tmp & tmp2 + '0'));
                        } else if (pop == '|') {
                            stack.add((char) (tmp | tmp2 + '0'));
                        }
                    } else {
                        stack.add(aChar);
                    }
                } else if (aChar == '&' || aChar == '|') {
                    stack.add(aChar);
                } else if (aChar == '(') {
                    stack.add(aChar);
                }
            }
            return 0;
        }

    }


}
