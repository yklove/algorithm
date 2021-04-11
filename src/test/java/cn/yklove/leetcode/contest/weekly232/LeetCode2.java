package cn.yklove.leetcode.contest.weekly232;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int findCenter(int[][] edges) {
            int[] count = new int[100001];
            int n = edges.length + 1;
            for (int[] edge : edges) {
                count[edge[0]]++;
                count[edge[1]]++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] == n - 1) {
                    return i;
                }
            }
            return 0;
        }
    }
}
