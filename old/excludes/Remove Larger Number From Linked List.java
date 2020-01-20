package excludes;

class Solution {


    public ListNode removeLargerNumbers(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) { 
            while (cur != null && cur.val < k) {
                pre = cur;
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            // now cur.val > k, pre.val < k
            // remove cur node
            pre.next = cur.next;
            cur = pre.next;
        }


        return dummy.next;

    }
}