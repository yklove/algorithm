package cn.yklove.leetcode.contest.weekly241;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode3 {
    class FindSumPairs {

        private int[] nums1;
        private int[] nums2;

        private Map<Integer, Integer> map1;
        private Map<Integer, Integer> map2;


        public FindSumPairs(int[] nums1, int[] nums2) {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int i : nums1) {
                map1.put(i, map1.getOrDefault(i, 0) + 1);
            }
            for (int i : nums2) {
                map2.put(i, map2.getOrDefault(i, 0) + 1);
            }
        }

        public void add(int index, int val) {
            map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) == 0 ? 0 : (map2.get(nums2[index]) - 1));
            map2.put(val + nums2[index], map2.getOrDefault(val + nums2[index], 0) + 1);
            nums2[index] += val;
        }

        public int count(int tot) {
            int ans = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map1.entrySet()) {
                if (map2.containsKey(tot - integerIntegerEntry.getKey())) {
                    ans += (integerIntegerEntry.getValue() * map2.get(tot - integerIntegerEntry.getKey()));
                }
            }
            return ans;
        }
    }

    /**
     * Your FindSumPairs object will be instantiated and called as such:
     * FindSumPairs obj = new FindSumPairs(nums1, nums2);
     * obj.add(index,val);
     * int param_2 = obj.count(tot);
     */

    @Test
    public void test() {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        findSumPairs.count(7);
        findSumPairs.add(3, 2);
        findSumPairs.count(8);
        findSumPairs.count(4);
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        findSumPairs.count(7);
    }
}
