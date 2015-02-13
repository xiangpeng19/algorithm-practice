
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
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        
        int leftDepth = getDepth(root.left, 1);
        int rightDepth = getDepth(root.right, 1);
        
        if (Math.abs(leftDepth - rightDepth) >= 2)
        	return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getDepth(TreeNode root, int currentDepth) {

    	if (root == null) {    		
    		return currentDepth;
    	}

    	return Math.max(getDepth(root.left, currentDepth + 1), 
    					getDepth(root.right, currentDepth + 1));
        
            	
	}
    public static void main(String[] args) {
    	
    }
}


