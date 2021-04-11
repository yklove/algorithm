package cn.yklove.leetcode.contest.weekly231;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode3 {


    class Solution2 {
        int mod = 1000000007;

        public int countRestrictedPaths(int n, int[][] es) {
            // 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] e : es) {
                int a = e[0], b = e[1], w = e[2];
                Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
                am.put(b, w);
                map.put(a, am);
                Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
                bm.put(a, w);
                map.put(b, bm);
            }

            // 堆优化 Dijkstra：求 每个点 到 第n个点 的最短路
            int[] dist = new int[n + 1];
            boolean[] st = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[n] = 0;
            Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 点编号，点距离。根据点距离从小到大
            q.add(new int[]{n, 0});
            while (!q.isEmpty()) {
                int[] e = q.poll();
                int idx = e[0];
                if (st[idx]) continue;
                st[idx] = true;
                Map<Integer, Integer> mm = map.get(idx);
                if (mm == null) continue;
                for (int i : mm.keySet()) {
                    dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                    q.add(new int[]{i, dist[i]});
                }
            }

            // dp 过程
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) arr[i] = new int[]{i + 1, dist[i + 1]}; // 点编号，点距离
            Arrays.sort(arr, Comparator.comparingInt(a -> a[1])); // 根据点距离从小到大排序

            // 定义 f(i) 为从第 i 个点到结尾的受限路径数量
            // 从 f[n] 递推到 f[1]
            int[] f = new int[n + 1];
            f[n] = 1;
            for (int i = 0; i < n; i++) {
                int idx = arr[i][0], cur = arr[i][1];
                Map<Integer, Integer> mm = map.get(idx);
                if (mm == null) continue;
                for (int next : mm.keySet()) {
                    if (cur > dist[next]) {
                        f[idx] += f[next];
                        f[idx] %= mod;
                    }
                }
                // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
                if (idx == 1) break;
            }
            return f[1];
        }
    }

    static class Solution {

        private int mod = 1000000000 + 7;

        private int ans = 0;

        public int countRestrictedPaths(int n, int[][] edges) {
            ans = 0;
            dp = new HashSet<>();
            Node[] list = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                Node node = new Node();
                node.i = i;
                node.nextNode = new HashMap<>();
                list[i] = node;
            }
            for (int[] edge : edges) {
                Node x = list[edge[0]];
                Node y = list[edge[1]];
                x.nextNode.put(y, edge[2]);
                y.nextNode.put(x, edge[2]);
            }
            Node nodeN = list[n];
            nodeN.distanceToLastNode = 0;
            distanceToLastNode(nodeN, new ArrayList<>());
            dfs(list[1], list[n], true, new ArrayList<>());
            return ans;
        }

        Set<Node> dp = new HashSet<>();

        private void dfs(Node node, Node n, boolean skill, List<Node> tmpList) {
            if (!skill) {
                return;
            }
            tmpList.add(node);
            if (node == n) {
                tmpList.remove(node);
                if (skill) {
                    ans++;
                    ans %= mod;
                }
                return;
            }
            for (Map.Entry<Node, Integer> entry : node.nextNode.entrySet()) {
                Node key = entry.getKey();
                if (tmpList.contains(key) || dp.contains(key)) {
                    continue;
                }
                boolean tmpSkill = skill;
                if (key == n) {
                    dfs(key, n, tmpSkill, tmpList);
                    continue;
                }
                if (node.distanceToLastNode <= key.distanceToLastNode) {
                    tmpSkill = false;
                    dp.add(key);
                    continue;
                }
                dfs(key, n, tmpSkill, tmpList);
            }
            tmpList.remove(node);
        }

        private void distanceToLastNode(Node node, List<Node> tmpList) {
            if (node == null) {
                return;
            }
            tmpList.add(node);
            for (Map.Entry<Node, Integer> entry : node.nextNode.entrySet()) {
                Node x = entry.getKey();
                Integer weight = entry.getValue();
                int tmpDistanceToLastNode = node.distanceToLastNode + weight;
                if (x.distanceToLastNode == null) {
                    x.distanceToLastNode = tmpDistanceToLastNode;
                } else {
                    x.distanceToLastNode = Math.min(x.distanceToLastNode, tmpDistanceToLastNode);
                }
                for (Map.Entry<Node, Integer> nodeIntegerEntry : x.nextNode.entrySet()) {
                    if (nodeIntegerEntry.getKey().distanceToLastNode != null) {
                        x.distanceToLastNode = Math.min(x.distanceToLastNode, nodeIntegerEntry.getKey().distanceToLastNode + nodeIntegerEntry.getValue());
                    }
                }
            }
            for (Map.Entry<Node, Integer> entry : node.nextNode.entrySet()) {
                Node x = entry.getKey();
                if (tmpList.contains(x)) {
                    continue;
                }
                distanceToLastNode(x, tmpList);
            }
        }

        class Node {
            int i;
            Integer distanceToLastNode;
            Map<Node, Integer> nextNode;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return i == node.i;
            }

            @Override
            public int hashCode() {
                return Objects.hash(i);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "i=" + i +
                        ", distanceToLastNode=" + distanceToLastNode +
                        '}';
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.countRestrictedPaths(5, new int[][]{
                {1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}
        });
        Assert.assertEquals(i, 3);
    }

    @Test
    public void test2() {
        int i = solution.countRestrictedPaths(7, new int[][]{
                {1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}
        });
        Assert.assertEquals(i, 1);
    }


}

class T {
    public static void main(String[] args) {
        LeetCode3.Solution solution = new LeetCode3.Solution();
        Scanner in = new Scanner(System.in);

        int i = in.nextInt();

        in.nextLine();
        String s = in.nextLine();
        String[] split = s.split("],\\[");
        int[][] a = new int[split.length][];
        for (int i1 = 0; i1 < split.length; i1++) {
            String s1 = split[i1];
            String substring = s1;
            List<Integer> collect = Arrays.stream(substring.split(",")).map(Integer::valueOf).collect(Collectors.toList());
            a[i1] = new int[collect.size()];
            for (int i2 = 0; i2 < collect.size(); i2++) {
                a[i1][i2] = collect.get(i2);
            }
        }
        int i1 = solution.countRestrictedPaths(i, a);
        System.out.println(i1);
    }
}