package cn.yklove.leetcode.contest.weekly240;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int max = 0;
            int i = 0;
            int j = i;
            for (; i < nums1.length; i++) {
                for (j = Math.max(i, j); j < nums2.length; j++) {
                    if (nums1[i] <= nums2[j]) {
                        max = Math.max(max, j - i);
                    } else {
                        break;
                    }
                }
            }
            return max;
        }
    }

}
