package excludes;

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
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        int n1 = 0;
        int n2 = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            n1++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            n2++;
            nodeB = nodeB.next;
        }
        
        int diff = Math.abs(n1 - n2);
        
        // make sure headA always point to a longer chain
        if (n1 < n2) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        while (diff > 0) {
            headA = headA.next;
            if (headA == null) {
                return null;
            }
            diff--;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    } 
}