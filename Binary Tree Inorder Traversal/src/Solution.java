import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
		if (root == null) return;
//    	if (root.left == null && root.right == null) list.add(root.val);
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
}
