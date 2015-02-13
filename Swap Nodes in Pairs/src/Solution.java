/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	ListNode helper = new ListNode(Integer.MAX_VALUE);
    	helper.next = head;
    	ListNode pre = helper, cur = head, next = cur.next;
    	
    	while(next != null) {
    		pre.next = next;    		
    		cur.next = next.next;
    		next.next = cur;
    		pre = cur;
    		cur = cur.next;
    		if (cur == null) break;
    		next = cur.next;
    		
    	}

    	return helper.next;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode n = new Solution().swapPairs(n1);
		while (n != null) {
		System.out.println(n.val);
		n = n.next;
		}
		
	}
}