class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // here is tricky, when we update the left pointer, 
                // we should compare it with current left pointer, 
                // otherwise the left pointer may go backwards
                left = Math.max(map.get(c) + 1, left);
                map.put(c, right);
            }
            map.put(c, right);
            max = Math.max(right - left + 1, max);
            right++;
        }
        
        return max;
        
    }
}