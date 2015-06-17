import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by lxp19_000 on 2015-05-26.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
/*        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            else map.put(nums[i], 1);
        }
        return false;*/
        if (nums.length == 0) return false;
        BitSet set = new BitSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.get(nums[i]) == false) set.set(nums[i], true);
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,5,-2,-4,0};
        System.out.print(new Solution().containsDuplicate(nums));

    }
}