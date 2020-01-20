import excludes.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<>();
        bfs(res, "", root);
        return res;
    }

    private void bfs(List<String> res, String cur, TreeNode node) {
        if (node == null) return;
        cur += node.val + "->";
        if (node.right == null && node.left == null) {
            cur = cur.substring(0, cur.length() - 2);
            res.add(cur);
            return;
        }
        bfs(res, cur, node.left);
        bfs(res, cur, node.right);
    }
 
}