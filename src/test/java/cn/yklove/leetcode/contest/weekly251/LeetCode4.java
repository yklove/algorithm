package cn.yklove.leetcode.contest.weekly251;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Node {
        String val;
        List<Node> nextList;

        public Node(String val, List<Node> nextList) {
            this.val = val;
            this.nextList = nextList;
        }
    }

    class Solution {

        private boolean theSame(Node node1, Node node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null) {
                return false;
            }
            if (node2 == null) {
                return false;
            }
            if (node1.nextList.size() != node2.nextList.size()) {
                return false;
            }
            for (int i = 0; i < node1.nextList.size(); i++) {
                if (!node1.nextList.get(i).val.equals(node2.nextList.get(i).val)) {
                    return false;
                }
                if (!theSame(node1.nextList.get(i), node2.nextList.get(i))) {
                    return false;
                }
            }
            if (node1.nextList.size() == 0 && node2.nextList.size() == 0) {
                return false;
            }
            return true;
        }


        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            Map<String, Node> map = new HashMap<>();
            Set<Node> root = new HashSet<>();
            for (List<String> path : paths) {
                String s = path.get(0);
                if (!map.containsKey(s)) {
                    map.put(s, new Node(s, new ArrayList<>()));
                }
                Node pre = map.get(s);
                root.add(pre);
                for (int i = 1; i < path.size(); i++) {
                    String tmpS = path.get(i);
                    if (!map.containsKey(tmpS)) {
                        map.put(tmpS, new Node(tmpS, new ArrayList<>()));
                    }
                    pre.nextList.add(map.get(tmpS));
                    pre = map.get(tmpS);
                }
            }
            for (Map.Entry<String, Node> stringNodeEntry : map.entrySet()) {
                stringNodeEntry.getValue().nextList.sort(Comparator.comparing(o -> o.val));
            }
            List<Node> list = new ArrayList<>();
            for (Map.Entry<String, Node> stringNodeEntry : map.entrySet()) {
                list.add(stringNodeEntry.getValue());
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (theSame(list.get(i), list.get(j))) {
                        set.add(list.get(i).val);
                        set.add(list.get(j).val);
                    }
                }
            }
            List<List<String>> ans = new ArrayList<>();
            for (Node node : root) {
                if (set.contains(node.val)) {
                    continue;
                }
                ans.addAll(getPath(node));
            }
            return ans;
        }

        private List<List<String>> getPath(Node node) {
            if (node.nextList.size() == 0) {
                return Collections.singletonList(Collections.singletonList(node.val));
            }
            List<List<String>> list = new ArrayList<>();
            list.add(Collections.singletonList(node.val));
            for (Node nextNode : node.nextList) {
                List<List<String>> path = getPath(nextNode);
                for (List<String> strings : path) {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(node.val);
                    tmp.addAll(strings);
                    list.add(tmp);
                }
            }
            return list;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(
                Arrays.asList(
                        Arrays.asList("c"),
                        Arrays.asList("c", "d"),
                        Arrays.asList("a"),
                        Arrays.asList("a", "b")
                ),
                solution.deleteDuplicateFolder(Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("c", "d"),
                        Arrays.asList("c"),
                        Arrays.asList("a"))));

    }

    @Test
    public void test2() {
        Assert.assertEquals(
                Arrays.asList(Arrays.asList("c"),
                        Arrays.asList("c", "b"),
                        Arrays.asList("a"),
                        Arrays.asList("a", "b")),
                solution.deleteDuplicateFolder(Arrays.asList(
                        Arrays.asList("a"),
                        Arrays.asList("c"),
                        Arrays.asList("a", "b"),
                        Arrays.asList("c", "b"),
                        Arrays.asList("a", "b", "x"),
                        Arrays.asList("a", "b", "x", "y"),
                        Arrays.asList("w"),
                        Arrays.asList("w", "y"))));


    }


}
