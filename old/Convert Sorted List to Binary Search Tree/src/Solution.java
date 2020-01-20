/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        return Helper(head);
    }

    // build bottom-to-top
    public TreeNode sortedListToBST(int start, int end) {
        // if finished (root)
        if(start > end) return null;

        // get mid val
        int mid = (start + end) / 2;

        // build left sub tree
        TreeNode left = sortedListToBST(start, mid - 1);
        // build root node
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        // move to next node to build right sub tree
        head = head.next;
        root.right = sortedListToBST(mid + 1, end);

        return root;
    }
    public static void main(String[] args) {
		
	}
}