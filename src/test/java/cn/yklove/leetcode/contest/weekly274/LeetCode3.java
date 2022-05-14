package cn.yklove.leetcode.contest.weekly274;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long count = mass;
            for (int asteroid : asteroids) {
                if(count >= asteroid){
                    count += asteroid;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

}
