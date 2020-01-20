package excludes;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int findTargetSumWays(final int[] nums, final int S) {
        final List<List<Boolean>> res = new ArrayList<>();
        find(nums, 0, S, 0, res, new ArrayList<>());
        return res.size();
    }

    private void find(final int[] nums, final int index, final int S, final int curSum, final List<List<Boolean>> res,
            final List<Boolean> cur) {
        // reach the end of array.
        // handle the last number
        if (index == nums.length - 1) {
            if (S == curSum + nums[index]) {
                // positive
                cur.add(Boolean.TRUE);
                res.add(new ArrayList(cur));
                return;
            } else if (S == curSum - nums[index]) {
                // negative
                cur.add(Boolean.FALSE);
                res.add(new ArrayList(cur));
                return;
            } else {
                return;
            }

        }

        for (int i = index; i < nums.length; i++) {
            // try positive
            cur.add(Boolean.TRUE);
            find(nums, index + 1, S, curSum + nums[index], res, cur);
            cur.remove(cur.size() - 1);

            // try negative
            cur.add(Boolean.FALSE);
            find(nums, index + 1, S, curSum - nums[index], res, cur);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[] nums = { 1, 1, 1, 1, 1 };
        final int S = 3;
        final int res = solution.findTargetSumWays(nums, S);
        System.out.println(res);

    }
}