public class Solution {

    public String findMostFrequentWord(String input, List<String> exclude) {
        if (input == null || input.length() == 0) {
            return input;
        }

        Set<String> set = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();
        String candidate = null;
        int candidateCount = 0;
        set.addAll(exclude);

        String[] words = input.split("\\W+");

        for (String word : words) {
            if (!set.contains(word)) {
                if (countMap.containsKey(word)) {
                    int count = countMap.get(word) + 1;
                    if (count > candidateCount) {
                        candidateCount = count;
                        candidate = word;
                    }
                    countMap.put(word, count);
                } else {
                    int count = 1;
                    if (count > candidateCount) {
                        candidateCount = count;
                        candidate = word;
                    }
                    countMap.put(word, count);
                }
            }
        }
        return candidate;
    }  
    
}