class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] strArr = str.toCharArray();
        char[] arr = new char[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = convert(strArr[i]);
        }

        return new String(arr);
        
    }

    private char convert(char c) {
        if (c >= 65 && c <= 90) {
            return (char) (c + 32);
        } else {
            return c;
        }
    }
}