package cn.yklove.leetcode.contest.weekly247;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public long wonderfulSubstrings(String word) {
            char[] chars = word.toCharArray();
            int[] count = new int[10];
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                count[chars[i] - 'a']++;
                ans++;
                for (int j = i + 1; j < chars.length; j++) {
                    count[chars[j] - 'a']++;
                    int tmp = 0;
                    for (int k = 0; k < 10; k++) {
                        tmp += (count[k] % 2 == 0) ? 0 : 1;
                    }
                    if (tmp < 2) {
                        ans++;
                    }
                }
                count[chars[i] - 'a']--;
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(9, solution.wonderfulSubstrings("aabb"));
    }

}
