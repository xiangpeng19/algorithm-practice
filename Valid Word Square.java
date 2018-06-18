class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String hori = words.get(i);
            String vert = getVertivalWord(words, i);
            if (!hori.equals(vert)) {
                return false;
            }
        }
        return true;
    }

    private String getVertivalWord(List<String> words, int i) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > i) {
                sb.append(word.charAt(i));
            }
        }

        return sb.toString();

    }
}