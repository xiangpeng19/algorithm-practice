import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxp19_000 on 2015-04-15.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0) return res;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            //the first element should be 1
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(j, pre.get(j - 1) + pre.get(j));
            }
            //the last element should be 1
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }

    public static void main (String[] args) {
        System.out.println(new Solution().generate(4));
    }
}