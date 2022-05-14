package cn.yklove.leetcode.contest.weekly263;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        public int secondMinimum(int n, int[][] edges, int time, int change) {
            Map<Integer, Edge> edgeMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                edgeMap.put(i, new Edge(i));
            }
            for (int[] edge : edges) {
                Edge x = edgeMap.get(edge[0]);
                Edge y = edgeMap.get(edge[1]);
                x.edgeList.add(y);
                y.edgeList.add(x);
            }
            List<Integer> objects = new ArrayList<>();
            process(edgeMap.get(1), 0, new HashSet<>(), objects, n);
            objects = objects.stream().distinct().sorted().collect(Collectors.toList());
            if (objects.size() == 1) {
                Integer count = objects.get(0);
                count += 2;
                int ans = 0;
                for (int i = 0; i < count; i++) {
                    if ((ans / change) % 2 == 1) {
                        ans += (change - ans % change);
                    }
                    ans += time;
                }
                return ans;
            }else{
                Integer count = objects.get(1);
                int ans = 0;
                for (int i = 0; i < count; i++) {
                    ans += time;
                    if ((ans / change) % 2 == 1) {
                        ans += (change - ans % change);
                    }
                }
                return ans;
            }
        }

        /**
         * 深度优先遍历
         *
         * @param edge
         */
        private void process(Edge edge, int depth, Set<Edge> edgeSet, List<Integer> tmpArray, int n) {
            if (edge.index == n) {
                tmpArray.add(depth);
                return;
            }
            if (edgeSet.contains(edge)) {
                return;
            }
            edgeSet.add(edge);
            // 记录深度
            for (Edge tmp : edge.edgeList) {
                process(tmp, depth + 1, edgeSet, tmpArray, n);
            }
            edgeSet.remove(edge);
        }

        class Edge {
            int index;
            Set<Edge> edgeList;

            public Edge(int index) {
                this.index = index;
                this.edgeList = new HashSet<>();
            }
        }

    }


    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.secondMinimum(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}, 3, 5);
        System.out.println(i);
    }
    @Test
    public void test2() {
        int i = solution.secondMinimum(2, new int[][]{{1, 2}}, 3, 2);
        System.out.println(i);
    }

    /**
     * 6
     * [[1,2],[1,3],[2,4],[3,5],[5,4],[4,6]]
     * 3
     * 2
     *
     * 预期15
     */
}
