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
    int answer = 0;
    private void zigZag(TreeNode node, boolean goRight, int depth) {
        if(node == null)
            return;
        
        if(depth > answer)
            answer = depth;
        
        if(goRight) {
            zigZag(node.right, false, depth + 1);
            zigZag(node.left, true, 1);
        }
        else {
            zigZag(node.left, true, depth + 1);
            zigZag(node.right, false, 1);
        }
    }
    public int longestZigZag(TreeNode root) {
        zigZag(root, true, 0);
        
        return answer;
    }
}