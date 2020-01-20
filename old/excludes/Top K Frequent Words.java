package excludes;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }


        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }


        return res;





    }
}