package excludes;

public class Solution {
    public ListNode compare(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode n1 = l1;
        ListNode n2 = l2;

        int num1 = 0, num2 = 0;

        while (n1 != null) {
            num1 *= 10;
            num1 += n1.val;
            n1 = n1.next;
        }

        while (n2 != null) {
            num2 *= 10;
            num2 += n2.val;
            n2 = n2.next;
        }

        if (num1 > num2) {
            return l1;
        } else {
            return l2;
        }

    }
}