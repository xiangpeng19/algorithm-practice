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
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode pt = head;
    	if (pt == null) return pt;
    	while (pt.next != null) {
//    		if (pt.next == null) return head;
    		ListNode curPt = pt; 
    		while (curPt.val == curPt.next.val) {
    			curPt = curPt.next;
    			if (curPt.next == null) break;
    		}
    		pt.next = curPt.next;
    		pt = pt.next;
    		if (pt == null) break;
    	}
    	return head;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
/*		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(6);*/
		n1.next = n2;
		n2.next = null;
/*		n3.next = n4;
		n4.next = n5;		
		n5.next = n6;
		n6.next = null;*/

		ListNode n = new Solution().deleteDuplicates(n1);
		
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
		
	}
}