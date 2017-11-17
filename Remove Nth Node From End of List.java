/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head; 
        
        ListNode node = new ListNode(0);
        node.next = head;
        
        
        ListNode slow = node;
        ListNode fast = head;
        
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next == null) {
            slow.next = null ;
        } else {
            slow.next = slow.next.next;
        }
        
        return node.next;
        
    }
}