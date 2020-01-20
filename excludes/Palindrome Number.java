package excludes;

public class Solution {
    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        char[] str = String.valueOf(num).toCharArray();
        int start = 0, end = str.length - 1;
        while (start <= end) {
            if (str[start] == str[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}