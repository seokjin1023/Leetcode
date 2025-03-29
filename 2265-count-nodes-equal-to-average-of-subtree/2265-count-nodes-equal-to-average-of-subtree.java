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
    private int answer = 0;

    private int[] dfs(TreeNode root, int sum, int visited) {
        if(root.left == null && root.right == null) {
            answer++;
            visited++;
            sum += root.val;
            return new int[]{sum, visited};
        }
        int[] leftSum = new int[2];
        int[] rightSum = new int[2];
        if(root.left != null) leftSum = dfs(root.left, sum, visited);
        if(root.right != null) rightSum = dfs(root.right, sum, visited);
        sum += root.val + leftSum[0] + rightSum[0];
        visited++;
        visited += leftSum[1] + rightSum[1];
        if(sum / visited == root.val) answer++;
        return new int[]{sum, visited};
    }
    public int averageOfSubtree(TreeNode root) {
        int[] v = dfs(root, 0, 0);
        return answer;
    }
}