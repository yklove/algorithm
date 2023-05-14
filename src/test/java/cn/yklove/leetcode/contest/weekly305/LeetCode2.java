package cn.yklove.leetcode.contest.weekly305;

import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            int ans = 1;
            Set<Integer> set = new HashSet<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                List<Integer> orDefault = map.getOrDefault(edge[0], new ArrayList<>());
                orDefault.add(edge[1]);
                map.put(edge[0], orDefault);
                List<Integer> orDefault2 = map.getOrDefault(edge[1], new ArrayList<>());
                orDefault2.add(edge[0]);
                map.put(edge[1], orDefault2);
            }
            for (int i : restricted) {
                set.add(i);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            Set<Integer> set1 = new HashSet<>();
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (set1.contains(poll)) {
                    continue;
                }
                set1.add(poll);
                List<Integer> list = map.get(poll);
                if (Objects.nonNull(list) && list.size() != 0) {
                    for (Integer integer : list) {
                        if (!set.contains(integer) && !set1.contains(integer)) {
                            queue.add(integer);
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.reachableNodes(7, new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}}, new int[]{4, 2, 1});
        System.out.println(i);
    }
}
