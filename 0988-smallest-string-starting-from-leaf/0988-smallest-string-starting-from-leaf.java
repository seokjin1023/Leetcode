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
    String answer = "";
    private String compare(String a, String b) {
        if(a.compareTo(b) < 0)
            return a;
        return b;
    }
    private void tree(StringBuilder sb, TreeNode current) {
        sb.append((char)('a' + current.val));
        if(current.left == null && current.right == null) {
            String candidate = sb.reverse().toString();
            sb.reverse();
            if(answer.equals(""))
                answer = candidate;
            else
                answer = compare(answer, candidate);
            return;
        }
        if(current.left != null) {
            tree(sb, current.left);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(current.right != null) {
            tree(sb, current.right);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree(sb, root);
        return answer;
    }
}