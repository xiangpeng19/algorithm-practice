package solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46 {

    public static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            var used = new boolean[nums.length];
            Arrays.fill(used, false);

            permute(new ArrayList<>(), res, nums, used);

            return res;
        }

        private void permute(List<Integer> cur, List<List<Integer>> res, int[] nums, boolean[] used) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            }

            // enumerate numbers for the current position
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    cur.add(nums[i]);
                    used[i] = true;
                    permute(cur, res, nums, used);

                    // restore the status
                    cur.remove(cur.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
