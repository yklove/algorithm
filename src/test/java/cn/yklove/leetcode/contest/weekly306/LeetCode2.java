package cn.yklove.leetcode.contest.weekly306;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int edgeScore(int[] edges) {
            Map<Integer, Long> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < edges.length; i++) {
                list.add(i);
                map.put(edges[i], map.getOrDefault(edges[i], 0L) + i);
            }
            list.sort((o1, o2) -> {
                int val = Long.compare(map.getOrDefault(o2, 0L), map.getOrDefault(o1, 0L));
                if (val != 0) {
                    return val;
                }
                return Long.compare(o1, o2);
            });
            return list.get(0);
        }
    }

}
