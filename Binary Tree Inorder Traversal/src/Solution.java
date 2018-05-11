/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();
        
        dfs(root, res);
        return res;
        
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        List<Integer> res = new ArrayList<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;

    }
}