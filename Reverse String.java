class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] as = s.toCharArray();
        int start = 0, end = as.length - 1;

        while (start < end) {
            swap(as, start, end);
            start++;
            end--;
        }

        return new String(as);
        
    }


    private void swap(char[] as, int i, int j) {
        char t = as[i];
        as[i] = as[j];
        as[j] = t;
    }
}