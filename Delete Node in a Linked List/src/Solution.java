/**
 * Created by lxp19_000 on 2015-07-15.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) node.next = null;
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}