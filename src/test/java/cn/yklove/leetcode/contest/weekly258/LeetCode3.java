package cn.yklove.leetcode.contest.weekly258;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {

        public int maxProduct(String s) {
            List<Integer> list = longestPalindrome(s);
            Integer[] arm_len = list.toArray(new Integer[]{});

            //--------- 前i个中，最大的臂长
            int[] prefix_max_arm_len = new int[arm_len.length];
            int left_center = 0;
            for (int i = 1; i < arm_len.length; i++) {
                while (left_center + arm_len[left_center] < i)
                    left_center++;
                prefix_max_arm_len[i] = Math.max(prefix_max_arm_len[i - 1], i - left_center);
            }

            //-------- 从i往右中，最大的臂长
            int[] suffix_max_arm_len = new int[arm_len.length];
            int right_center = arm_len.length - 1;
            for (int i = arm_len.length - 2; i > -1; i--) {
                while (right_center - arm_len[right_center] > i)
                    right_center--;
                suffix_max_arm_len[i] = Math.max(suffix_max_arm_len[i + 1], right_center - i);
            }

            long res = 0;
            for (int i = 0; i < arm_len.length - 1; i++) {
                long l_len = 2 * prefix_max_arm_len[i] + 1;
                long r_len = 2 * suffix_max_arm_len[i + 1] + 1;
                res = Math.max(res, l_len * r_len);
            }
            return (int) res;
        }

        public List<Integer> longestPalindrome(String s) {
            int start = 0, end = -1;
            StringBuffer t = new StringBuffer("#");
            for (int i = 0; i < s.length(); ++i) {
                t.append(s.charAt(i));
                t.append('#');
            }
            t.append('#');
            s = t.toString();

            List<Integer> arm_len = new ArrayList<Integer>();
            int right = -1, j = -1;
            for (int i = 0; i < s.length(); ++i) {
                int cur_arm_len;
                if (right >= i) {
                    int i_sym = j * 2 - i;
                    int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                    cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
                } else {
                    cur_arm_len = expand(s, i, i);
                }
                arm_len.add(cur_arm_len);
                if (i + cur_arm_len > right) {
                    j = i;
                    right = i + cur_arm_len;
                }
                if (cur_arm_len * 2 + 1 > end - start) {
                    start = i - cur_arm_len;
                    end = i + cur_arm_len;
                }
            }
            return arm_len;
        }

        public int expand(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return (right - left - 2) / 2;
        }

    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(9, solution.maxProduct("leetcodecom"));
    }

}
