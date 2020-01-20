/**
 * Created by lxp19_000 on 2015-04-14.
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a == "") return b;
        if (b == "") return a;

        //first use the StringBuffer to reverse the string
        StringBuffer aR = new StringBuffer(a);
        a = aR.reverse().toString();
        StringBuffer bR = new StringBuffer(b);
        b = bR.reverse().toString();

        int carry = 0;
        int curIndex;
        StringBuffer res = new StringBuffer();

        char[] Sa = a.toCharArray();
        char[] Sb = b.toCharArray();


        int aMax = Sa.length;
        int bMax = Sb.length;

        //find out the shorter string
        int Min = (aMax < bMax) ? aMax : bMax;

        for (curIndex = 0; curIndex < Min; curIndex++) {
            if (curIndex >= aMax || curIndex >= bMax) break;
            int temp = Sa[curIndex] + Sb[curIndex] + carry - 2 * '0';
            switch (temp) {
                case 0:
                    carry = 0;
                    res.append("0");
                    break;
                case 1:
                    carry = 0;
                    res.append("1");
                    break;
                case 2:
                    carry = 1;
                    res.append("0");
                    break;
                case 3:
                    carry = 1;
                    res.append("1");
                    break;
            }
        }
        while (curIndex < aMax) {
            int temp = Sa[curIndex++] + carry - '0';
            switch (temp) {
                case 0:
                    carry = 0;
                    res.append("0");
                    break;
                case 1:
                    carry = 0;
                    res.append("1");
                    break;
                case 2:
                    carry = 1;
                    res.append("0");
                    break;
            }
        }

        while (curIndex < bMax) {
            int temp = Sb[curIndex++] + carry - '0';
            switch (temp) {
                case 0:
                    carry = 0;
                    res.append("0");
                    break;
                case 1:
                    carry = 0;
                    res.append("1");
                    break;
                case 2:
                    carry = 1;
                    res.append("0");
                    break;
            }
        }

        if (carry == 1) res.append("1");

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("111111", "1"));
    }
}
