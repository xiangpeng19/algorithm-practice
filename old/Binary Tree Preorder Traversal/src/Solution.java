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
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); 
		return recursive(root, list);
	}
	
	public static List<Integer> recursive(TreeNode root, List<Integer> list) {
		if (root == null) return list;
		if (root != null) list.add(root.val);
		if (root.left != null) recursive(root.left, list);
		if (root.right != null) recursive(root.right, list);
		
		return list;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
        List<Integer> list = new ArrayList<Integer>(); 
        list = preorderTraversal(n1);
        for (Integer i : list) {
			System.out.println(i);
		}
	}
	
}
