package cn.yklove.offer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem26 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null && A != null) {
                return false;
            }
            return process(A, B);
        }

        private boolean process(TreeNode a, TreeNode b) {
            if (equalsTreeNode(a, b)) {
                return true;
            }
            if (a.left != null) {
                boolean process = process(a.left, b);
                if (process) {
                    return true;
                }
            }
            if (a.right != null) {
                boolean process = process(a.right, b);
                if (process) {
                    return true;
                }
            }
            return false;
        }

        private boolean equalsTreeNode(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null || a.val != b.val) {
                return false;
            }
            return equalsTreeNode(a.left, b.left) && equalsTreeNode(a.right, b.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode getTreeNode(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            treeNodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; 2 * i + 1 < arr.length; i++) {
            if (2 * i + 1 < arr.length) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }
            if (2 * i + 2 < arr.length) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }
        return treeNodes[0];
    }

    private Solution solution = new Solution();


    @Test
    public void test1() {
        Assert.assertTrue(solution.isSubStructure(getTreeNode(new int[]{1, 2, 3, 4}), getTreeNode(new int[]{3})));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.isSubStructure(getTreeNode(new int[]{1, 2, 3}), getTreeNode(new int[]{3, 1})));
    }

    @Test
    public void test3() {
        Assert.assertTrue(solution.isSubStructure(getTreeNode(new int[]{3, 4, 5, 1, 2}), getTreeNode(new int[]{4, 1})));
    }

    @Test
    public void test4() {
        Assert.assertFalse(solution.isSubStructure(getTreeNode(new int[]{-1, 3, 2, 0}), getTreeNode(new int[]{})));
    }

}