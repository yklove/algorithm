package cn.yklove.leetcode.contest.weekly322;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int minScore(int n, int[][] roads) {
            int ans = Integer.MAX_VALUE;
            Map<Integer, List<Integer[]>> roadMap = new HashMap<>();
            for (int[] road : roads) {
                int key = road[0];
                if (!roadMap.containsKey(key)) {
                    roadMap.put(key, new ArrayList<>());
                }
                List<Integer[]> list = roadMap.get(key);
                Integer[] tmp = new Integer[2];
                tmp[0] = road[1];
                tmp[1] = road[2];
                list.add(tmp);

                key = road[1];
                if (!roadMap.containsKey(key)) {
                    roadMap.put(key, new ArrayList<>());
                }
                list = roadMap.get(key);
                tmp = new Integer[2];
                tmp[0] = road[0];
                tmp[1] = road[2];
                list.add(tmp);
            }
            List<Integer[]> integers = roadMap.get(1);
            LinkedList<Integer[]> list = new LinkedList<>(integers);
            Set<Integer> set = new HashSet<>();
            set.add(1);
            while (list.size() != 0) {
                Integer[] first = list.pollFirst();
                if (!set.contains(first[0])) {
                    set.add(first[0]);
                    list.addAll(roadMap.getOrDefault(first[0], new ArrayList<>()));
                }
                ans = Math.min(first[1],ans);
            }
            return ans;
        }
    }

}
