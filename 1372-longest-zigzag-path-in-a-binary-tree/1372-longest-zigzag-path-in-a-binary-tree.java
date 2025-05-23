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

/* 
Solution with bfs
class Solution {
    private class Treedepth {
        TreeNode node;
        int depth;
        boolean goRight;

        Treedepth(TreeNode node, boolean goRight, int depth) {
            this.node = node;
            this.goRight = goRight;
            this.depth = depth;
        }
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        Queue<Treedepth> queue = new LinkedList<>();
        queue.add(new Treedepth(root, true, 0));  // 오른쪽 이동
        queue.add(new Treedepth(root, false, 0)); // 왼쪽 이동

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            Treedepth current = queue.poll();
            maxDepth = Math.max(maxDepth, current.depth);  // 바로 최대값 갱신

            if (current.node.right != null) {
                queue.add(new Treedepth(current.node.right, false, current.goRight ? current.depth + 1 : 1));
            }
            if (current.node.left != null) {
                queue.add(new Treedepth(current.node.left, true, current.goRight ? 1 : current.depth + 1));
            }
        }
        return maxDepth;
    }
*/
