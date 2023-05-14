package cn.yklove.leetcode.contest.weekly325;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int closetTarget(String[] words, String target, int startIndex) {
            int right = 0;
            int tmp = startIndex;
            do {
                if (words[tmp].equals(target)) {
                    break;
                }
                right++;
                tmp = (tmp + 1) % words.length;
            } while (tmp != startIndex);
            if(right == words.length){
                return -1;
            }
            int left = 0;
            tmp = startIndex;
            do {
                if (words[tmp].equals(target)) {
                    break;
                }
                left++;
                tmp = (tmp - 1 + words.length) % words.length;
            } while (tmp != startIndex);
            return Math.min(left,right);
        }
    }

}
