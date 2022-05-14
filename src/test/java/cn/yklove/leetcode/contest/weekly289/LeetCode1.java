package cn.yklove.leetcode.contest.weekly289;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                int count = 0;
                int sum = 0;
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : s.toCharArray()) {
                    sum += (c - '0');
                    count++;
                    if (count == k) {
                        stringBuilder.append(sum);
                        count = 0;
                        sum = 0;
                    }
                }
                if (count != 0) {
                    stringBuilder.append(sum);
                }
                s = stringBuilder.toString();
            }
            return s;
        }
    }

}
