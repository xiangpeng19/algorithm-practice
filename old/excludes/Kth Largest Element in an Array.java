package excludes;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            pq.offer(num);
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();        
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();        
    }
}