package cn.yklove.leetcode.contest.weekly265;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int smallestEqual(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if(i % 10 == nums[i]){
                    return i;
                }
            }
            return -1;
        }
    }

}
