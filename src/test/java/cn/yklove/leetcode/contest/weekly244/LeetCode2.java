package cn.yklove.leetcode.contest.weekly244;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int reductionOperations(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());
            arrayList.sort((o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()));
            int ans = 0;
            int tmp = 0;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                ans += (tmp + arrayList.get(i).getValue());
                tmp = (tmp + arrayList.get(i).getValue());
            }
            return ans;
        }
    }

}
