package cn.yklove.leetcode.contest.weekly283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public List<String> cellsInRange(String s) {
            List<String> ans = new ArrayList<>();
            String[] split = s.split(":");
            char a = split[0].charAt(0);
            char b = split[0].charAt(1);
            char c = split[1].charAt(0);
            char d = split[1].charAt(1);
            for (char i = a; i <= c; i++) {
                for (char j = b; j <= d; j++) {
                    ans.add(i + "" + j);
                }
            }
            return ans;
        }
    }

}
