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
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);

        if (left != null && right != null) {
            TreeNode n = (left.val > right.val) ? left : right;
            return root.val > n.val ? root : n;
        } else if (left != null) {
            return root.val > left.val ? root : left;
        } else if (right != null) {
            return root.val > right.val ? root : right;
        } else {
            return root;
        }
    }
    
}