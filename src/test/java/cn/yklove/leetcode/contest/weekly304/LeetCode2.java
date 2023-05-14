package cn.yklove.leetcode.contest.weekly304;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int maximumGroups(int[] grades) {
            int length = grades.length;
            int i = 1;
            int sum = 1;
            while (true) {
                i++;
                if (sum + i == length) {
                    return i;
                } else if (sum + i > length) {
                    return i - 1;
                } else {
                    sum += i;
                }
            }
        }
    }

}
