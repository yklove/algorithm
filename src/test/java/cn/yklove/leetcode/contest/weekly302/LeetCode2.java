package cn.yklove.leetcode.contest.weekly302;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int maximumSum(int[] nums) {
            List<Integer>[] list = new ArrayList[82];
            for (int num : nums) {
                int tmp = num;
                int sum = 0;
                while (tmp != 0) {
                    sum += tmp % 10;
                    tmp /= 10;
                }
                if (list[sum] == null) {
                    list[sum] = new ArrayList<>();
                }
                list[sum].add(num);
            }
            int ans = -1;
            for (int i = list.length - 1; i >= 0; i--) {
                List<Integer> tmp = list[i];
                if(tmp == null || tmp.size() < 2){
                    continue;
                }
                tmp.sort(Comparator.reverseOrder());
                ans = Math.max(tmp.get(0) + tmp.get(1),ans);
            }
            return ans;
        }
    }

    Solution solution = new Solution();
    @Test
    public void test(){
        Assert.assertEquals(solution.maximumSum(new int[]{18,43,36,13,7}),54);
    }


}
