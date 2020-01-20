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
    public TreeNode sortedArrayToBST(int[] num) {
    	return creatNode(num, 0, num.length - 1);
    	
    }
        
    public TreeNode creatNode(int[] num, int start, int end) {
		if (start > end) return null;
		int mid = start + ((end - start) >> 1);
		TreeNode node = new TreeNode(num[mid]);
		node.left = creatNode(num, start, mid - 1);
		node.right = creatNode(num, mid + 1, end);
		return node;
	}
    
    public static void main(String[] args) {
		
	}
}
