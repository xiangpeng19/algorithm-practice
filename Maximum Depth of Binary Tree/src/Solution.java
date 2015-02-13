

public class Solution {

	public int maxDepth(TreeNode root) {
		
        if (root == null) return 0;
        int leftDepth, rightDepth;
        
        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
	
	
	
	public static void main(String[] args) {
		
	}
}
