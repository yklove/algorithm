package cn.yklove.leetcode.contest.weekly206;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            List<Edge> list = new ArrayList<>();
            int[][] arr = new int[points.length][points.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    list.add(new Edge(i, j, arr[i][j]));
                }
            }
            Collections.sort(list);
            //数组中每一个节点都只知道他的父节点是什么，-1表示不存在父节点，0位置是根节点
            int[] parent = new int[arr.length];
            for (int i = 1; i < arr.length; i++) {
                parent[i] = -1;
            }
            int m = 0, n = 0;
            for (Edge edge : list) {
                //寻找这两个点有没有相同的父节点
                m = find(parent, edge.getBegin());
                n = find(parent, edge.getEnd());
                if (m != n && parent[edge.getEnd()] > 0) {
                    parent[edge.getEnd()] = edge.getBegin();
                }
            }
            System.out.println(Arrays.toString(parent));


            int ans = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1) {
                    continue;
                }
                ans += (Math.abs(points[i][0] - points[parent[i]][0]) + Math.abs(points[i][1] - points[parent[i]][1]));
            }
            return ans;
        }

        private int find(int[] parent, int ch) {
            while (parent[ch] > 0) {
                ch = parent[ch];
            }
            return ch;
        }
    }

    class Edge implements Comparable<Edge> {
        //起始点
        private int begin;
        //终止点
        private int end;
        //权值
        private int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (o.weight > this.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(20, solution.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        }));
    }
}
