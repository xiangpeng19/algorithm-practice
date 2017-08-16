class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return res;
        }
        
        Arrays.sort(nums);

        dfs(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int index, int[] nums) {
        res.add(new ArrayList<Integer>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}