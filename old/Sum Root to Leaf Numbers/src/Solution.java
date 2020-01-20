/**
 * Created by lxp19_000 on 2015-04-22.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumhelper(root, root.val, 0);
    }

    int sumhelper(TreeNode root, int result, int level) {
        if (root.left == null && root.right == null) return result += root.val * Math.pow(10, level);
        if (root.left != null) sumhelper(root.left, result)

    }

    public static void main(String[] args) {

    }
}