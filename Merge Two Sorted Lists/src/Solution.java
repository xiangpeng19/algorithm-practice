

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) return l2;
    	if (l2 == null) return l1;
    	
    	ListNode head = null, curNode = null;
    	while (l1 != null && l2 != null) {
    		if (l1.val < l2.val) {
    			ListNode newNode = new ListNode(l1.val); 
    			if (head == null) {
    				head = newNode;
    				curNode = newNode;
    			}
    			else {
					curNode.next = newNode;
					curNode = curNode.next;
				}
    			l1 = l1.next;    		
    		}    	
    		else {
				ListNode newNode = new ListNode(l2.val);
				if (head == null) {
    				head = newNode;
    				curNode = newNode;
    			}
    			else {
					curNode.next = newNode;
					curNode = curNode.next;
				}
				l2 = l2.next;  		
    		}    					
		}
    	while (l1 != null) {
    		curNode.next = l1;
    		curNode = curNode.next;
    		l1 = l1.next;
    	}
    	while (l2 != null) {
    		curNode.next = l2;
    		curNode = curNode.next;
    		l2 = l2.next;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(0);
//		ListNode n5 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		ListNode n = new Solution().mergeTwoLists(n1, n4);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
}