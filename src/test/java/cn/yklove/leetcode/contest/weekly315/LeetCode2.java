package cn.yklove.leetcode.contest.weekly315;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int countDistinctIntegers(int[] nums) {
            Set<String> set = new HashSet<>();
            int ans = 0;
            for (int num : nums) {
                String s = Integer.toString(num);
                String s2 = new StringBuilder(s).reverse().toString();
                s2 = Integer.toString(Integer.parseInt(s2));
                if (!set.contains(s)) {
                    ans++;
                }
                set.add(s);
                if (!set.contains(s2)) {
                    ans++;
                }
                set.add(s2);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.countDistinctIntegers(new int[]{1, 13, 10, 12, 31}), 6);
    }


}
