package cn.yklove.leetcode.contest.weekly303;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean key = true;
                    for (int k = 0; k < n; k++) {
                        if(grid[i][k] != grid[k][j]){
                            key = false;
                            break;
                        }
                    }
                    if(key){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
