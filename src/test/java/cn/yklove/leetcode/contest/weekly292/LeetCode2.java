package cn.yklove.leetcode.contest.weekly292;

import java.util.Objects;

/**
 * @author beamjl
 */
public class LeetCode2 {

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
        public int averageOfSubtree(TreeNode root) {
            return process(root).successCount;
        }

        private Info process(TreeNode root) {
            int count = 1;
            int sum = root.val;
            int successCount = 0;
            if (Objects.nonNull(root.left)) {
                Info process = process(root.left);
                count += process.count;
                sum += process.sum;
                successCount += process.successCount;
            }
            if (Objects.nonNull(root.right)) {
                Info process = process(root.right);
                count += process.count;
                sum += process.sum;
                successCount += process.successCount;
            }
            int avg = sum / count;
            if (avg == root.val) {
                successCount++;
            }
            return new Info(sum, count, successCount);
        }

        class Info {
            int sum;
            int count;
            int successCount;

            public Info(int sum, int count, int successCount) {
                this.sum = sum;
                this.count = count;
                this.successCount = successCount;
            }
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

}
