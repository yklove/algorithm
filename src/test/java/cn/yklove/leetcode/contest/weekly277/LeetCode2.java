package cn.yklove.leetcode.contest.weekly277;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }
            LinkedList<Integer> one = new LinkedList<>();
            LinkedList<Integer> two = new LinkedList<>();
            for (int num : nums) {
                if (num >= 0) {
                    one.add(num);
                } else {
                    two.add(num);
                }
            }
            int[] ans = new int[nums.length];
            int i = 0;
            while (i < nums.length) {
                if (i % 2 == 0) {
                    ans[i] = one.pollFirst();
                } else {
                    ans[i] = two.pollFirst();
                }
                i++;
            }
            return ans;
        }
    }

}
