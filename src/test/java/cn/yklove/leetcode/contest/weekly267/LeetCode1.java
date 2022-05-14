package cn.yklove.leetcode.contest.weekly267;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int ans = 0;
            int index = 0;
            while (tickets[k] != 0) {
                if (tickets[index] != 0) {
                    ans++;
                    tickets[index]--;
                }
                index = (index + 1) % tickets.length;
            }
            return ans;
        }
    }

}
