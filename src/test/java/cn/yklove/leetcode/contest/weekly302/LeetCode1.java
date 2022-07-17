package cn.yklove.leetcode.contest.weekly302;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] count = new int[101];
            for (int num : nums) {
                count[num]++;
            }
            int a = 0;
            int b = 0;
            for (int i = 0; i < 101; i++) {
                a += count[i] / 2;
                b += count[i] % 2;
            }
            return new int[]{a, b};
        }
    }

}
