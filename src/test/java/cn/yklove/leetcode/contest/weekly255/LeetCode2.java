package cn.yklove.leetcode.contest.weekly255;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            int length = nums[0].length();
            int max = (int) Math.pow(2.0, length);
            Set<Integer> set = new HashSet<>();
            for (String num : nums) {
                set.add(Integer.valueOf(num, 2));
            }
            for (int i = 0; i < max; i++) {
                if(!set.contains(i)){
                    String s = Integer.toBinaryString(i);
                    if(s.length() < length){
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < length - s.length(); j++) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(s);
                        s = stringBuilder.toString();
                    }
                    return s;
                }
            }
            return "";
        }
    }

}
