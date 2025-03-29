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
    private int depth(TreeNode root, int deep) {
        if(root == null) return deep;
        
        int leftDepth = depth(root.left, deep + 1);
        int rightDepth = depth(root.right, deep + 1);
        return Math.max(leftDepth, rightDepth);
    }
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
}