package cn.yklove.leetcode.contest.weekly275;

import org.junit.Test;

import java.lang.reflect.AnnotatedWildcardType;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int minSwaps(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (num == 1) {
                    count++;
                }
            }
            if(count == 0){
                return 0;
            }
            int[] tmpNums = new int[nums.length + count - 1];
            for (int i = 0; i < nums.length; i++) {
                tmpNums[i] = nums[i];
            }
            for (int i = nums.length; i < tmpNums.length; i++) {
                tmpNums[i] = nums[i - nums.length];
            }
            int max = 0;
            int tmpSum = 0;
            for (int i = 0; i < count; i++) {
                tmpSum +=tmpNums[i];
            }
            max = Math.max(max, tmpSum);
            for (int i = count; i < tmpNums.length; i++) {
                tmpSum +=tmpNums[i];
                tmpSum -=tmpNums[i - count];
                max = Math.max(max,tmpSum);
            }
            return count - max;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        solution.minSwaps(new int[]{0,0,0});
    }


}
