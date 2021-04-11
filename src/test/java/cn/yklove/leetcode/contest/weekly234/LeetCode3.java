package cn.yklove.leetcode.contest.weekly234;

import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> strings : knowledge) {
                String key = strings.get(0);
                String value = strings.get(1);
                map.put(key, value);
            }
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char aChar : chars) {
                if (aChar != ')') {
                    stack.add(aChar);
                } else {
                    if (stack.isEmpty()) {
                        stack.add(aChar);
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    boolean key = true;
                    while (!stack.isEmpty()) {
                        Character character = stack.pop();
                        if (character != '(') {
                            stringBuilder.append(character);
                            continue;
                        }
                        String s1 = stringBuilder.reverse().toString();
                        if (map.containsKey(s1)) {
                            String s2 = map.get(s1);
                            for (char c : s2.toCharArray()) {
                                stack.add(c);
                            }
                            key = false;
                            break;
                        } else {
                            stack.add('?');
                            key = false;
                            break;
                        }
                    }
                    if (key) {
                        stack.add(aChar);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.reverse().toString();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        String evaluate = solution.evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two")));
        System.out.println(evaluate);
    }
}
