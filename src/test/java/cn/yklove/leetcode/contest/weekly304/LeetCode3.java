package cn.yklove.leetcode.contest.weekly304;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            Map<Integer, Integer> node1Map = new HashMap<>();
            node1Map.put(node1,0);
            process(edges, node1, 0, node1Map);
            Map<Integer, Integer> node2Map = new HashMap<>();
            node2Map.put(node2,0);
            process(edges, node2, 0, node2Map);
            int ans = Integer.MAX_VALUE;
            int ansValue = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : node1Map.entrySet()) {
                if (node2Map.containsKey(entry.getKey())) {
                    int value = Math.max(entry.getValue(), node2Map.get(entry.getKey()));
                    if (value < ansValue) {
                        ans = entry.getKey();
                        ansValue = value;
                    } else if (value == ansValue) {
                        if (entry.getKey() < ans) {
                            ans = entry.getKey();
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1:ans;
        }

        private void process(int[] edges, int node, int count, Map<Integer, Integer> nodeMap) {
            if (edges[node] == -1) {
                return;
            }
            if (nodeMap.containsKey(edges[node])) {
                return;
            }
            nodeMap.put(edges[node], count + 1);
            process(edges, edges[node], count + 1, nodeMap);
        }

    }

}
