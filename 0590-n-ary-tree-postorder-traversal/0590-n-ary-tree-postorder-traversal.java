/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private List<Integer> answer = new ArrayList<>();

    private void dfs(Node node) {
        if(node.children.isEmpty()) {
            answer.add(node.val);
            return;
        }
        for(Node child : node.children) {
            dfs(child);
        }
        answer.add(node.val);
    }
    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();
        dfs(root);
        return answer;
    }
}