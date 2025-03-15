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
    private class Treedepth {
        TreeNode node;
        boolean goRight;
        int depth;

        Treedepth(TreeNode node, boolean goRight, int depth) {
            this.node = node;
            this.goRight = goRight;
            this.depth = depth;
        }
    }
    public int longestZigZag(TreeNode root) {
        int answer = 0;
        Queue<Treedepth> que = new LinkedList<>();
        que.add(new Treedepth(root, true, 0));
        que.add(new Treedepth(root, false, 0));
        while(!que.isEmpty()) {
            Treedepth treedepth = que.poll();
            if(treedepth.goRight) {
                if(treedepth.node.right != null)
                    que.add(new Treedepth(treedepth.node.right, false, treedepth.depth + 1));
                else
                    answer = Math.max(answer, treedepth.depth);
                if(treedepth.node.left != null)
                    que.add(new Treedepth(treedepth.node.left, true, 1));
            }
            else {
                if(treedepth.node.left != null)
                    que.add(new Treedepth(treedepth.node.left, true, treedepth.depth + 1));
                else
                    answer = Math.max(answer, treedepth.depth);
                if(treedepth.node.right != null)
                    que.add(new Treedepth(treedepth.node.right, false, 1));
            }
        }
        
        return answer;
    }
}