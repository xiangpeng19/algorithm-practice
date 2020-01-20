import java.util.HashMap;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    	if (head == null) return false;    	
    	ListNode nodefast = head;
    	ListNode nodeslow = head;

    	while (nodefast != null && nodefast.next != null) {
    		nodefast = nodefast.next.next;
    		nodeslow = nodeslow.next;
    		if (nodeslow == nodefast) return true;

    	}
    	return false;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
/*		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);*/
		n1.next = n2;
//		n2.next = null;
/*		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n1;*/
		System.out.println(new Solution().hasCycle(n1));
	}
}