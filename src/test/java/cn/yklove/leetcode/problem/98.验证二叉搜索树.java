/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.37%)
 * Likes:    2234
 * Dislikes: 0
 * Total Accepted:    815.5K
 * Total Submissions: 2.2M
 * Testcase Example:  '[2,1,3]'
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 
 * 
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Info info = dfs(root);
        return info.result;
    }

    private Info dfs(TreeNode root){
        Info info = new Info();
        if(root == null){
            info.max = Integer.MIN_VALUE;
            info.min = Integer.MAX_VALUE;
            info.result = true;
            return info;
        }
        info.max = root.val;
        info.min = root.val;
        if(root.left != null){
            Info left = dfs(root.left);
            if(!left.result){
                return left;
            }
            if(root.val <= left.max){
                info.result = false;
                return info;
            }
            info.min = Math.min(left.min,info.min);
        }
        if(root.right != null){
            Info right = dfs(root.right);
            if(!right.result){
                return right;
            }
            if(root.val >= right.min){
                info.result = false;
                return info;
            }
            info.max = Math.max(right.max, info.max);
        }
        info.result = true;
        return info;
    }

    class Info{
        int max;
        int min;
        boolean result;
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}