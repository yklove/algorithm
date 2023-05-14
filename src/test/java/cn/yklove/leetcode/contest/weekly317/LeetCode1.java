package cn.yklove.leetcode.contest.weekly317;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int averageValue(int[] nums) {
            int count = 0;
            long sum = 0;
            for (int num : nums) {
                if (num % 2 == 0 && num % 3 == 0) {
                    sum += num;
                    count++;
                }
            }
            if(count == 0){
                return 0;
            }
            return (int) (sum / count);
        }
    }

}
