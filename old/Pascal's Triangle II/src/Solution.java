import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxp19_000 on 2015-04-15.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();

        res.add(1);
        if (rowIndex <= 0) return res;

        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        res.add(1);
        }
        return res;
/*
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        if (rowIndex < 0) return pre;

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(j, pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
*/
    }

    public static void main(String[] args) {
        System.out.print(new Solution().getRow(6));
    }
}