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
    boolean answer = true;
    private void check(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if((p == null && q != null) || (p != null && q == null))
                answer = false;
            return ;
        }
        if(p.val != q.val) answer = false;
        check(p.left, q.left);
        check(p.right, q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return answer;
    }
}