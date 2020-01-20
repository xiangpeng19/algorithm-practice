/**
 * Created by lxp19_000 on 2015-03-28.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long t = n&0x0FFFFFFFF;

        int result = 0;
        while (t != 0) {
            t &= (t - 1);
            result++;
        }
        return result;

        //the slow method, check every bit recursively
/*      long t = n&0x0FFFFFFFF;
        if (t == 0) return 0;
        if (t < 0) n = -n;
        int result = 0;

        for (int i = 1; i < 33; i++) {
            if ((t & 1) == 1) result++;
            t = t >> 1;
        }
        return result;
*/
    }

    public static void main(String[] args) {
        long n = 4294967295L;
    //    int n = 1;
        System.out.println(new Solution().hammingWeight(n));
    }
}