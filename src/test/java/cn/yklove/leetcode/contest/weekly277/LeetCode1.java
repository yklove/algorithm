package cn.yklove.leetcode.contest.weekly277;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int countElements(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                boolean min = false;
                boolean max = false;
                for (int j = 0; j < nums.length; j++) {
                    if(i != j && nums[j] < nums[i]){
                        min = true;
                    }
                    if(i != j && nums[j] > nums[i]){
                        max = true;
                    }
                }
                if(max && min){
                    count++;
                }
            }
            return count;
        }
    }

}
