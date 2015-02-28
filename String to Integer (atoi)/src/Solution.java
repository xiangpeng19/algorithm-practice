/**
 * Created by lxp19_000 on 2015-02-27.
 */
public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] s = str.toCharArray();
        int len = s.length;

        //record the first number in the string
        int i = 0;

        boolean positive = true;
        int count = 0;
        int valueBefore = 0;
        int valueAfter = 0;

        //discard all invaild characters
        while(i < len) {
            if ((s[i] < '0' || s[i] > '9') && (s[i] != '+' && s[i] != '-')) i++;
            else break;
        }

        if (i > len - 1) return Integer.MAX_VALUE;

        //decide whether it's positive

        if (s[i] == '-') {
            positive = false;
            i++;
        }
        if (s[i] == '+') {
            i++;
        }


        //transform here
        for (int j = len - 1; j >= i; j--) {
            if (s[j] < '0' || s[j] > '9') continue;

            //when it's a positive number
            if ((s[j] > '0' && s[j] < '9') && positive) {

                valueAfter = valueBefore + (int)Math.pow(10, count++) * (s[j] - '0');
                if (valueAfter  < valueBefore) return Integer.MAX_VALUE;
                valueBefore = valueAfter;

            }

            //when it's a negetive number
            if ((s[j] > '0' && s[j] < '9') && !positive) {

                valueAfter = valueBefore - (int)Math.pow(10, count++) * (s[j] - '0');
                if (valueAfter  > valueBefore) return Integer.MAX_VALUE;
                valueBefore = valueAfter;

            }
        }

        return valueAfter;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().atoi("sss1sss"));

    }
}