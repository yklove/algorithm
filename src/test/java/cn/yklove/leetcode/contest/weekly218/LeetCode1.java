package cn.yklove.leetcode.contest.weekly218;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public String interpret(String command) {
            return command.replaceAll("[(]al[)]","al").replaceAll("[(][)]","o");
        }
    }

}
