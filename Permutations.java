public class Solution {
    /*
     * @param nums: a list of integers.
     * @return: a list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if (nums == null || nums.length == 0) return res;
        boolean[] isUsed = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), nums, isUsed);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] isUsed) {
       if (cur.size() == nums.length) {
           res.add(new ArrayList<Integer>(cur));
       }

       for (int i = 0; i < nums.length; i++) {
           if (isUsed[i]) continue;
           isUsed[i] = true;
           cur.add(nums[i]);
           helper(res, cur, nums, isUsed);
           isUsed[i] = false;
           cur.remove(cur.size() - 1);
       }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] isVisited = new boolean[nums.length];
        find(res, isVisited, new ArrayList<Integer>(), nums);

        return res;
    }

    private void find(List<List<Integer>> res, boolean[] isVisited, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            cur.add(nums[i]);
            find(res, isVisited, cur, nums);
            cur.remove(cur.size() - 1);
            isVisited[i] = false;
        }
    }
}