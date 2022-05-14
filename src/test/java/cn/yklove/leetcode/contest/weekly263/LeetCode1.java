package cn.yklove.leetcode.contest.weekly263;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public boolean areNumbersAscending(String s) {
            String[] strings = s.split(" ");
            int start = Integer.MIN_VALUE;
            for (String string : strings) {
                try {
                    int i = Integer.parseInt(string);
                    if (i <= start) {
                        return false;
                    }
                    start = i;
                } catch (Exception e) {

                }
            }
            return true;
        }
    }

}
