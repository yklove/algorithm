package cn.yklove.meituan;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class Main4 {

    // 小美的美丽树
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            Node node = new Node();
            node.index = i;
            node.value = in.nextInt();
            nodes[i] = node;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            List<Integer> list = map.getOrDefault(x, new ArrayList<>());
            list.add(y);
            map.put(x, list);
            list = map.getOrDefault(y, new ArrayList<>());
            list.add(x);
            map.put(y, list);
        }
        int root = in.nextInt();
        process(root, map, nodes, new HashSet<>());
        Node nodeRoot = nodes[root];
        Info info = process2(nodeRoot, K);
        System.out.println(info.ans);
    }

    private static Info process2(Node node, int k) {
        Info info = new Info();
        info.min = node.value;
        info.max = node.value;
        info.ans = node.index;
        if (node.child == null || node.child.size() == 0) {
            info.count = 1;
            return info;
        }
        // 维护新的min max 和count
        for (Node tmpNode : node.child) {
            Info tmp = process2(tmpNode, k);
            if (tmp.count > k) {
                continue;
            }
            info.max = Math.max(tmp.max, info.max);
            info.min = Math.min(tmp.min, info.min);
            info.count = Math.max(tmp.count, info.count);
            if ((tmp.max - tmp.min) > (info.max - info.min)) {
                info.ans = tmp.ans;
            } else if ((tmp.max - tmp.min) == (info.max - info.min)) {
                info.ans = Math.min(tmp.ans, info.ans);
            }
        }
        info.count++;
        return info;
    }

    private static void process(int root, Map<Integer, List<Integer>> map, Node[] nodes, Set<Integer> set) {
        if (set.contains(root)) {
            return;
        }
        set.add(root);
        List<Integer> list = map.get(root);
        if (list == null || list.size() == 0) {
            return;
        }
        Node treeRoot = nodes[root];
        treeRoot.child = list.stream()
                .filter(integer -> !set.contains(integer))
                .map(integer -> nodes[integer]).collect(Collectors.toList());
        for (Integer integer : list) {
            process(integer, map, nodes, set);
        }
    }

    static class Info {
        int min;
        int max;
        int ans;
        int count;
    }

    static class Node {
        int value;
        int index;
        List<Node> child;
    }

}
