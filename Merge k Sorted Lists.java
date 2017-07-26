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
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(100, new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (!minHeap.isEmpty()) {
            ListNode curMin = minHeap.poll();
            if (curMin.next != null) {
                minHeap.offer(curMin.next);
            }
            node.next = curMin;
            node = node.next;
        }

        return dummy.next;
    }
}
