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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if ((p == null && q != null) || (p != null && q == null)) return false;
		 if (p.left == null && p.right == null && q.left == null && q.right == null && p.val == q.val)	return true;
		 if (p != null && q != null && p.val == q.val) {
			 return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			 
		 }
		 return false;
// more neat code		 
/*		 if (p == null && q == null) return true;
		 if (p != null && q != null && p.val == q.val) 
			 return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		 return false;*/
		 
	}
	
	public static void main(String[] args) {
		
	}
}
