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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        return traverse(root, sum);
        
    }
    
    public boolean traverse(TreeNode node, int rem) {
		if (node == null) return false;
		if (node.left == null && node.right == null) {
			rem -= node.val;
			if (rem == 0) return true;
		}

		return traverse(node.right, rem - node.val) || traverse(node.left, rem - node.val);		
	}
    
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		System.out.println(new Solution().hasPathSum(n1, 3));
		
	}
}