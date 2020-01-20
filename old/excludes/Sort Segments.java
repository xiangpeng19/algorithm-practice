package excludes;

class Solution {

    public String convert(String input) {
        if (input == null || input.length() == 0)
            return "";
        List<String> strArr = divide(input);
        StringBuilder res = new StringBuilder();
        for (String word : strArr) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            res.append(sorted);
        }
        return res.toString();
    }

    public List<String> divide(String input) {
        List<String> segments = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            char pre = input.charAt(i - 1);
            char cur = input.charAt(i);
            if (!belongToSameGroup(pre, cur)) {
                segments.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(cur);

        }
        segments.add(sb.toString());
        return segments;
    }

    private boolean belongToSameGroup(char pre, char cur) {
        if (pre <= '9' && pre >= '0') {
            return cur <= '9' && cur >= '0';
        } else {
            return cur <= 'Z' && cur >= 'A';
        }
    }
}