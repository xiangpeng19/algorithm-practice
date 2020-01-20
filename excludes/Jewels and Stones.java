package excludes;

class Solution {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return count;
        }

        Set<Character> set = new HashSet<>();

        for (char c : J.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
        
    }

}