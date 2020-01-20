package excludes;

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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if (l1 != null) {
            node.next = l1;
        }
        
        if (l2 != null) {
            node.next = l2;
        }        
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);

    }
}