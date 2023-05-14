package cn.yklove.leetcode.contest.weekly317;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode4 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        Map<TreeNode, Integer> left;
        Map<TreeNode, Integer> right;
        Map<TreeNode, Integer> sum;
        Map<Integer, TreeNode> treeMap;
        Map<TreeNode, TreeNode> parent;

        public int[] treeQueries(TreeNode root, int[] queries) {
            if (root == null) {
                return new int[]{0};
            }
            left = new HashMap<>();
            right = new HashMap<>();
            sum = new HashMap<>();
            treeMap = new HashMap<>();
            parent = new HashMap<>();
            deep(root);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int query = queries[i];
                TreeNode treeNode = treeMap.get(query);
                ans[i] = extracted(root, treeNode, sum.get(treeNode) + 1);
            }
            return ans;
        }

        private int extracted(TreeNode root, TreeNode treeNode, int diff) {
            if (treeNode == root) {
                return Math.max(sum.get(treeNode) - diff, Math.min(left.get(treeNode), right.get(treeNode)));
            }
            TreeNode parentNode = parent.get(treeNode);
            int deepLeft = left.get(parentNode);
            int deepRight = right.get(parentNode);
            if (parentNode.left == treeNode) {
                if (deepRight >= deepLeft) {
                    return sum.get(root);
                } else {
                    // 向上传递影响
                    return extracted(root, parent.get(treeNode), deepRight != 0?Math.min(diff,deepRight):diff);
                }
            } else {
                if (deepLeft >= deepRight) {
                    return sum.get(root);
                } else {
                    // 向上传递影响
                    return extracted(root, parent.get(treeNode), deepLeft != 0 ?Math.min(diff,deepLeft):diff);
                }
            }
        }

        private int deep(TreeNode root) {
            if (root == null) {
                return -1;
            }
            treeMap.put(root.val, root);
            int deepLeft = deep(root.left) + 1;
            int deepRight = deep(root.right) + 1;
            left.put(root, deepLeft);
            right.put(root, deepRight);
            int deepSum = Math.max(deepLeft, deepRight);
            sum.put(root, deepSum);
            if (Objects.nonNull(root.left)) {
                parent.put(root.left, root);
            }
            if (Objects.nonNull(root.right)) {
                parent.put(root.right, root);
            }
            return Math.max(deepLeft, deepRight);
        }
    }

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

    LeetCode4.Solution solution = new Solution();

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        Assert.assertArrayEquals(new int[]{2}, solution.treeQueries(root, new int[]{4}));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        Assert.assertArrayEquals(new int[]{3, 2, 3, 2}, solution.treeQueries(root, new int[]{3, 2, 4, 8}));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(2);
        root.right.left.right = new TreeNode(4);
        Assert.assertArrayEquals(new int[]{1, 0, 3, 3, 3}, solution.treeQueries(root, new int[]{3, 5, 4, 2, 4}));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(6);
        Assert.assertArrayEquals(new int[]{2, 2, 2}, solution.treeQueries(root, new int[]{3, 4, 3}));
    }

}
