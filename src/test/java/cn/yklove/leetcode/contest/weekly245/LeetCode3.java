package cn.yklove.leetcode.contest.weekly245;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {
            boolean x = false;
            boolean y = false;
            boolean z = false;
            for (int[] triplet : triplets) {
                // 寻找第一位 = target的
                if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                    if(triplet[0] == target[0]){
                        x = true;
                    }
                    if(triplet[1] == target[1]){
                        y = true;
                    }
                    if(triplet[2] == target[2]){
                        z = true;
                    }
                }
            }
            return x && y && z;
        }
    }

}
