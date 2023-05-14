package cn.yklove.leetcode.contest.weekly316;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            if(event1[0].compareTo(event2[0]) > 0){
                String[] tmp = event1;
                event1 = event2;
                event2 = tmp;
            }
            String s = event1[1];
            String[] split = s.split(":");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            String s2 = event2[0];
            String[] split2 = s2.split(":");
            int x2 = Integer.parseInt(split2[0]);
            int y2 = Integer.parseInt(split2[1]);

            if (x2 > x) {
                return false;
            }
            if (x2 < x) {
                return true;
            }
            if(y2 > y){
                return false;
            }
            return true;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        Assert.assertFalse(solution.haveConflict(new String[]{"10:00","11:00"},new String[]{"14:00","15:00"}));
    }

    @Test
    public void test2(){
        Assert.assertFalse(solution.haveConflict(new String[]{"14:13","22:08"},new String[]{"02:40","08:08"}));
    }

}
