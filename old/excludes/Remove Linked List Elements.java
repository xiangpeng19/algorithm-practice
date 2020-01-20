package excludes;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode dummy = new ListNode(val - 1);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null) {
            while (cur.next != null && cur.next.val != val) {
                cur = cur.next;
            }

            if (cur.next != null) {
                cur.next = cur.next.next;
            }         
        }

        return dummy.next;
    }
}