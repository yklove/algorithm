package cn.yklove.leetcode.contest.weekly274;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public boolean checkString(String s) {
            char[] chars = s.toCharArray();
            int start = Integer.MAX_VALUE;
            for (int i = 0; i < chars.length; i++) {
                if(start == Integer.MAX_VALUE && chars[i] == 'b'){
                    start = i;
                }
                if(chars[i] == 'a' && i > start){
                    return false;
                }
            }
            return true;
        }
    }

}
