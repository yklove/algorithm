package cn.yklove.offer58;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qinggeng
 */
public class Main2 {

    class Solution {

        public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if (input == null || input.length == 0 || input[0] == -1) {
                ans.add(new ArrayList<>());
                ans.add(new ArrayList<>());
                ans.add(new ArrayList<>());
                return ans;
            }
            TreeNode[] treeNodes = new TreeNode[input.length];
            for (int i = 0; i < input.length; i++) {
                if (input[i] != -1) {
                    treeNodes[i] = new TreeNode(input[i]);
                }
            }
            for (int i = 0; i < input.length; i++) {
                if (i * 2 + 1 < input.length) {
                    treeNodes[i].left = treeNodes[i * 2 + 1];
                }
                if (i * 2 + 2 < input.length) {
                    treeNodes[i].right = treeNodes[i * 2 + 2];
                }
            }
            ans.add(preorderTraversal(treeNodes[0]));
            ans.add(inorderTraversal(treeNodes[0]));
            ans.add(postorderTraversal(treeNodes[0]));
            return ans;
        }

        class TreeNode {
            TreeNode left;
            TreeNode right;
            int val;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        private ArrayList<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            ArrayList<Integer> output = new ArrayList<>();
            if (root == null) {
                return output;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }


        private ArrayList<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }

        private ArrayList<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> arrayLists;
        arrayLists = solution.binaryTreeScan(new int[]{1, 7, 2, 6, -1, 4, 8});
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(new int[]{-1});
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(new int[]{3});
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(new int[]{1, 2, 3});
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(new int[]{});
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(null);
        System.out.println(arrayLists);
        arrayLists = solution.binaryTreeScan(new int[]{1, 2, -1, 3});
        System.out.println(arrayLists);
    }


}
