import java.util.HashMap;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
/*        if (headA == null || headB == null) return null;
        ListNode A = headA, B = headB;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (A != null || B != null) {
        	if (map.containsKey(A.val)) return A;
        	map.put(A.val, 1);
        	if (map.containsKey(B.val)) return A;
        	else map.put(B.val, 1);
        	A = A.next; 
        	B = B.next;
        }
    	return null;*/
        if (headA == null || headB == null) return null;
        ListNode A = headA, B = headB;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (A != null) {
        	map.put(A.val, 1);
        	A = A.next;
        }
        while (B != null) {
        	if (map.containsKey(B.val)) return B;
        	B = B.next;
        }
    	return null;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		ListNode n = new Solution().getIntersectionNode(n1, n4);
		System.out.println(n.val);
		
	}
}