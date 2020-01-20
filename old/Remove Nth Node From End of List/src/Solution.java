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
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur, pre;
		cur = head;
		pre = head;
		for (int i = 0; i <= n + 1; i++) {
			if (cur.next == null)
				break;
			cur = cur.next;
		}
		
		if (cur.next == null && n == 1) {
			cur = null;
			return head;
		}
		
		while (cur != null) {
			cur = cur.next;
			pre = pre.next;
		}
		
		pre.next = pre.next.next;
		
		return head;
    }
	
	public static void main(String[] args) {
		ListNode list = new ListNode(10);
		ListNode list1 = new ListNode(130);
		list.next = list1;
		ListNode i = list;
		while (i != null) {
			System.out.println(i.val);
			i = i.next;
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		} 
	}
}


