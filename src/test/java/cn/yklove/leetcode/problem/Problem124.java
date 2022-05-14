package cn.yklove.leetcode.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @author qinggeng
 */
public class Problem124 {

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

        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            process(root);
            return max;
        }

        public int process(TreeNode node) {
            if (Objects.isNull(node)) {
                return 0;
            }
            int left = Math.max(0, process(node.left));
            int right = Math.max(0, process(node.right));
            max = Math.max(max, left + right + node.val);
            return Math.max(left, right) + node.val;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        int i = solution.maxPathSum(root);
        Assert.assertEquals(2, i);
    }
}
