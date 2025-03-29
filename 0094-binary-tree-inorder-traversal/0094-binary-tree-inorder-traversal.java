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
    List<Integer> answer = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if(root.left == null && root.right == null) {
            answer.add(root.val);
            return ;
        }
        if(root.left != null) inOrder(root.left);
        answer.add(root.val);
        if(root.right != null) inOrder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return answer;
        inOrder(root);
        return answer;
    }
}