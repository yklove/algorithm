package cn.yklove.leetcode.contest.weekly283;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int[] description : descriptions) {
                TreeNode parent = map.getOrDefault(description[0], new TreeNode(description[0]));
                TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));
                if (description[2] == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                set.add(description[1]);
                map.put(description[0], parent);
                map.put(description[1], child);
            }
            for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
                if(!set.contains(entry.getKey())){
                    return entry.getValue();
                }
            }
            return null;
        }
    }

}
