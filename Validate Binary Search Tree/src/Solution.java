/**
 * Created by lxp19_000 on 2015-04-16.
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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) return false;

            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            return isValidBST(root.right);

        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
  //      TreeNode n4 = new TreeNode(4);
   //     TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
     //   n2.left = n4;
     //   n3.right = n5;
        System.out.println(new Solution().isValidBST(n1));
    }
}