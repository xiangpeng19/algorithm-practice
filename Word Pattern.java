class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] ps = pattern.toCharArray();
        String[] words = str.split(" ");

        if (ps.length == 0 || words.length == 0 || ps.length != words.length) {
            return false;
        }
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();

        for (int i = 0; i < ps.length; i++) {
            char c = ps[i];
            String w = words[i];
            if (!c2s.containsKey(c) && !s2c.containsKey(w)) {
                // if both don't contain, it means this is a new mapping
                c2s.put(c, w);
                s2c.put(w, c);
            } else if (!c2s.containsKey(c) || !s2c.containsKey(w)) {
                // if only one contains, this is not a bijection
                return false;
            } else if (c2s.containsKey(c) && s2c.containsKey(w)) {
                if (!c2s.get(c).equals(w) || !s2c.get(w).equals(c)) {
                    return false;
                }
            } else {
                return false;
            }

        }

        return true;

    }
}