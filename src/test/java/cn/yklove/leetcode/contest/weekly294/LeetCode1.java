package cn.yklove.leetcode.contest.weekly294;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int percentageLetter(String s, char letter) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if(c == letter){
                    count++;
                }
            }
            return count* 100  / s.length() ;
        }
    }

}
