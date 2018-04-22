class Solution {
    
    
    Map<Character, String> map = new HashMap<>();
    Set<String> set =new HashSet();
    
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        } else if (map.containsKey(pattern.charAt(0))) {
            String comp = map.get(pattern.charAt(0));
            if (str.length() < comp.length() || !comp.equals(str.substring(0, comp.length()))) {
                return false;
            }
            return wordPatternMatch(pattern.substring(1), str.substring(comp.length()));
        } else {

            for (int i = 1; i <= str.length(); i++) {
                char c  = pattern.charAt(0);
                String cur = str.substring(0, i);
                if(set.contains(cur)) {
                    continue;
                }
                set.add(cur);
                map.put(c, cur);
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }
                map.remove(c);
                set.remove(cur);
            }

        }
        return false;
    }
}