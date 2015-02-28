import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxp19_000 on 2015-02-27.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        int max = 2 << S.length;
        int Sindex = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            Sindex = 0;
            while (Sindex < S.length) {
                if ((i & 0x01) == 1) list.add(S[Sindex]);
                i = i >> 1;
                Sindex++;
            }
            res.add(list);

        }

        for(ArrayList i : res) {
            for (Object j : i)
                System.out.print(j);
            System.out.println();
        }
        return null;
    }


    public static void main(String[] args) {
        int A[] = {1,4,5,6,7};
        new Solution().subsets(A);
    }
}